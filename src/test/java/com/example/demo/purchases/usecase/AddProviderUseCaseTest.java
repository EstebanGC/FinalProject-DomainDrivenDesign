package com.example.demo.purchases.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.commands.AddProvider;
import com.example.demo.purchases.events.ProviderCreated;
import com.example.demo.purchases.events.PurchasingBookCreated;
import com.example.demo.purchases.values.Contact;
import com.example.demo.purchases.values.ProviderId;
import com.example.demo.purchases.values.PurchasingBookId;
import com.example.demo.purchases.values.BookStore;
import com.example.demo.purchases.values.Name;
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
class AddProviderUseCaseTest {
    @InjectMocks
    private AddProviderUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddProviderHappyPass() {

        PurchasingBookId purchasingBookId = PurchasingBookId.of("xxxxx");
        ProviderId providerId = ProviderId.of("yyyyy");
        Name name = new Name("alberto");
        Contact contact = new Contact("wwwww");
        var command = new AddProvider(purchasingBookId, providerId, name, contact);

        Mockito.when(repository.getEventsBy("xxxxx")).thenReturn(History());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPurchasingBookId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        var event = (ProviderCreated)events.get(0);
        Assertions.assertEquals(command.getPurchasingBookId().value(), event.aggregateRootId());
        Assertions.assertEquals(command.getProviderId().value(), event.getProviderId().value());
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getContact().value(), event.getContact().value());

        Mockito.verify(repository).getEventsBy(command.getPurchasingBookId().value());
    }

    private List<DomainEvent> History() {
        PurchasingBookId purchasingBookId = PurchasingBookId.of("xxxxx");
        BookStore bookStore = new BookStore(200);
        var event = new PurchasingBookCreated(purchasingBookId, bookStore);
        return List.of(event);
    }
}

