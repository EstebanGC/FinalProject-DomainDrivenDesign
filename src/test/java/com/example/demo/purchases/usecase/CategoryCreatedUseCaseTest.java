package com.example.demo.purchases.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.purchases.values.PurchasingBookId;
import com.example.demo.purchases.events.CategoryCreated;
import com.example.demo.purchases.events.PurchasingBookCreated;
import com.example.demo.purchases.usecase.CategoryCreatedUseCase;
import com.example.demo.purchases.values.BookStore;
import com.example.demo.purchases.values.Category;
import com.example.demo.purchases.values.PurchasingBookId;

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
class CategoryCreatedUseCaseTest {
    @InjectMocks
    private CategoryCreatedUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void CategoryCreatedHappyPass() {

        PurchasingBookId purchasingBookId = PurchasingBookId.of("xxxxx");
        PurchasedBookId purchasedBookId = PurchasedBookId.of("yyyyy");
        Category category = new Category("Horror");

        var event = new CategoryCreated(purchasingBookId, purchasedBookId, category);

        Mockito.when(repository.getEventsBy(event.getPurchasingBookId().value())).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.getPurchasingBookId().value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow().getDomainEvents();

        var eventResponse = (CategoryCreated)events.get(0);
        Assertions.assertEquals(event.getPurchasingBookId().value(), eventResponse.aggregateRootId());
        Assertions.assertEquals(event.getPurchasedBookId().value(), eventResponse.getPurchasedBookId().value());
        Assertions.assertEquals(event.getCategory().value(), eventResponse.getCategory().value());

        Mockito.verify(repository).getEventsBy(event.getPurchasingBookId().value());
    }

    private List<DomainEvent> History() {
        PurchasingBookId purchasingBookId = PurchasingBookId.of("xxxxx");
        BookStore bookStore = new BookStore(200);
        var event = new PurchasingBookCreated(purchasingBookId, bookStore);
        return List.of(event);
    }

}