package com.example.demo.selling.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.example.demo.selling.events.CategoryCreated;
import com.example.demo.selling.SellingBook;

public class CategoryCreatedUseCase extends UseCase<TriggeredEvent<CategoryCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CategoryCreated> categoryCreatedTriggeredEvent) {
        var event = categoryCreatedTriggeredEvent.getDomainEvent();
        var sellingBook = SellingBook.from(event.getSellingBookId(), this.retrieveEvents());
        sellingBook.addCategory(event.getSellingBookId(), event.getSellingId(),event.getCategory());
        emit().onResponse(new ResponseEvents(sellingBook.getUncommittedChanges()));
    }
}
