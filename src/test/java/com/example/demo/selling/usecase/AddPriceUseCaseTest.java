package com.example.demo.selling.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.commands.AddPrice;
import com.example.demo.selling.events.PriceCreated;
import com.example.demo.selling.events.SellingBookCreated;
import com.example.demo.selling.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class AddPriceUseCaseTest {
    @InjectMocks
    private AddPriceUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddPriceHappyPass() {

        SellingBookId sellingBookId = SellingBookId.of("xxxxx");
        SellingId sellingId = SellingId.of("yyyyy");
        Price price = new Price(50000);
        var command = new AddPrice(sellingBookId, sellingId, price);

        Mockito.when(repository.getEventsBy("xxxxx")).thenReturn(History());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSellingBookId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        var event = (PriceCreated)events.get(0);
        Assertions.assertEquals(command.getSellingBookId().value(), event.aggregateRootId());
        Assertions.assertEquals(command.getSellingId().value(), event.getSellingId().value());
        Assertions.assertEquals(command.getPrice().value(), event.getPrice().value());

        Mockito.verify(repository).getEventsBy(command.getSellingBookId().value());
    }

    private List<DomainEvent> History() {
        SellingBookId sellingBookId = SellingBookId.of("xxxxx");
        BookStore bookStore = new BookStore(200);
        var event = new SellingBookCreated(sellingBookId, bookStore);
        return List.of(event);
    }

}
