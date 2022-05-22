package com.example.demo.selling.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.commands.AddCategory;
import com.example.demo.selling.events.CategoryCreated;
import com.example.demo.selling.events.SellingBookCreated;
import com.example.demo.selling.values.BookStore;
import com.example.demo.selling.values.Category;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SellingId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddCategoryUseCaseTest {
    @InjectMocks
    private AddCategoryUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddCategoryHappyPass() {

        SellingBookId sellingBookId = SellingBookId.of("xxxxx");
        SellingId sellingId = SellingId.of("yyyyy");
        Category category = new Category("SciFi");
        var command = new AddCategory(sellingBookId, sellingId, category);

        Mockito.when(repository.getEventsBy("xxxxx")).thenReturn(History());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSellingBookId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        var event = (CategoryCreated)events.get(0);
        Assertions.assertEquals("xxxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyyy", event.getSellingId().value());
        Assertions.assertEquals("SciFi", event.getCategory().value());

        Mockito.verify(repository).getEventsBy(command.getSellingBookId().value());
    }

    private List<DomainEvent> History() {
        SellingBookId sellingBookId = SellingBookId.of("xxxxx");
        BookStore bookStore = new BookStore(200);
        var event = new SellingBookCreated(sellingBookId, bookStore);
        return List.of(event);
    }

}