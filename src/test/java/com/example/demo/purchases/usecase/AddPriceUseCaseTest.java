package com.example.demo.purchases.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.commands.AddPrice;
import com.example.demo.purchases.events.ContactCreated;
import com.example.demo.purchases.events.PriceCreated;
import com.example.demo.purchases.events.PurchasingBookCreated;
import com.example.demo.purchases.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddPriceUseCaseTest {
    @InjectMocks
    private AddPriceUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddContactHappyPass() {

        PurchasingBookId purchasingBookId = PurchasingBookId.of("xxxxx");
        PurchasedBookId purchasedBookId = PurchasedBookId.of("yyyyy");
        Price price = new Price(30000);
        var command = new AddPrice(purchasingBookId, purchasedBookId, price);

        Mockito.when(repository.getEventsBy("xxxxx")).thenReturn(History());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPurchasingBookId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        var event = (PriceCreated)events.get(0);
        Assertions.assertEquals(command.getPurchasingBookId().value(), event.aggregateRootId());
        Assertions.assertEquals(command.getPurchasedBookId().value(), event.getPurchasedBookId().value());
        Assertions.assertEquals(command.getPrice().value(), event.getPrice().value());

        Mockito.verify(repository).getEventsBy(command.getPurchasingBookId().value());
    }

    private List<DomainEvent> History() {
        PurchasingBookId purchasingBookId = PurchasingBookId.of("xxxxx");
        BookStore bookStore = new BookStore(200);
        var event = new PurchasingBookCreated(purchasingBookId, bookStore);
        return List.of(event);
    }

}