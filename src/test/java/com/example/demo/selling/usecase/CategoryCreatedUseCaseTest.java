package com.example.demo.selling.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.events.CategoryCreated;
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

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CategoryCreatedUseCaseTest {

    @InjectMocks
    private CategoryCreatedUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void CategoryCreatedHappyPass() {

        SellingBookId sellingBookId = SellingBookId.of("xxxxx");
        SellingId sellingId = SellingId.of("yyyyy");
        Category category = new Category("alberto");

        var event = new CategoryCreated(sellingBookId, sellingId, category);

        Mockito.when(repository.getEventsBy(event.getSellingBookId().value())).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.getSellingBookId().value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow().getDomainEvents();

        var eventResponse = (CategoryCreated)events.get(0);
        Assertions.assertEquals(event.getSellingBookId().value(), eventResponse.aggregateRootId());
        Assertions.assertEquals(event.getSellingId().value(), eventResponse.getSellingId().value());
        Assertions.assertEquals(event.getCategory().value(), eventResponse.getCategory().value());

        Mockito.verify(repository).getEventsBy(event.getSellingBookId().value());
    }

    private List<DomainEvent> History() {
        SellingBookId sellingBookId = SellingBookId.of("xxxxx");
        BookStore bookStore = new BookStore(200);
        var event = new SellingBookCreated(sellingBookId, bookStore);
        return List.of(event);
    }
}