package com.example.demo.purchases.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.commands.AddPurchase;
import com.example.demo.purchases.events.PurchaseCreated;
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
class AddPurchaseUseCaseTest {
    @InjectMocks
    private AddPurchaseUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddPurchaseHappyPass() {

        PurchasingBookId purchasingBookId = PurchasingBookId.of("xxxxx");
        PurchaseId purchaseId = PurchaseId.of("yyyyy");
        NumberOfBooks numberOfBooks = new NumberOfBooks(40);
        TotalPrice totalPrice= new TotalPrice(500000);
        var command = new AddPurchase(purchasingBookId, purchaseId, numberOfBooks, totalPrice);

        Mockito.when(repository.getEventsBy("xxxxx")).thenReturn(History());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPurchasingBookId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        var event = (PurchaseCreated)events.get(0);
        Assertions.assertEquals(command.getPurchasingBookId().value(), event.aggregateRootId());
        Assertions.assertEquals(command.getPurchaseId().value(), event.getPurchaseId().value());
        Assertions.assertEquals(command.getNumberOfBooks().value(), event.getNumberOfBooks().value());
        Assertions.assertEquals(command.getTotalPrice().value(), event.getNumberOfBooks().value());

        Mockito.verify(repository).getEventsBy(command.getPurchasingBookId().value());
    }

    private List<DomainEvent> History() {
        PurchasingBookId purchasingBookId = PurchasingBookId.of("xxxxx");
        BookStore bookStore = new BookStore(200);
        var event = new PurchasingBookCreated(purchasingBookId, bookStore);
        return List.of(event);
    }

}