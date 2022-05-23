package com.example.demo.selling.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.commands.AddSeller;
import com.example.demo.selling.events.SellerCreated;
import com.example.demo.selling.events.SellingBookCreated;
import com.example.demo.selling.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddSellerUseCaseTest {

    @InjectMocks
    private AddSellerUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddSellerHappyPass() {

        SellingBookId sellingBookId = SellingBookId.of("xxxxx");
        SellerId sellerId = SellerId.of("yyyyy");
        Name name = new Name("alberto");
        SoldBooks soldBooks = new SoldBooks(20);
        var command = new AddSeller(sellingBookId, sellerId, name, soldBooks);

        Mockito.when(repository.getEventsBy("xxxxx")).thenReturn(History());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSellingBookId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        var event = (SellerCreated)events.get(0);
        Assertions.assertEquals(command.getSellingBookId().value(), event.aggregateRootId());
        Assertions.assertEquals(command.getSellerId().value(), event.getSellerId().value());
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getSoldBooks().value(), event.getSoldBooks().value());

        Mockito.verify(repository).getEventsBy(command.getSellingBookId().value());
    }

    private List<DomainEvent> History() {
        SellingBookId sellingBookId = SellingBookId.of("xxxxx");
        BookStore bookStore = new BookStore(200);
        var event = new SellingBookCreated(sellingBookId, bookStore);
        return List.of(event);
    }
}
