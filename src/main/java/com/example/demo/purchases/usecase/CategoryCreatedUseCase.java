package com.example.demo.purchases.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.example.demo.purchases.PurchasingBook;
import com.example.demo.selling.SellingBook;
import com.example.demo.purchases.events.CategoryCreated;

public class CategoryCreatedUseCase extends UseCase<TriggeredEvent<CategoryCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CategoryCreated> categoryCreatedTriggeredEvent) {
        var event = categoryCreatedTriggeredEvent.getDomainEvent();
        var purchasingBook = PurchasingBook.from(event.getPurchasingBookId(), this.retrieveEvents());
        purchasingBook.addCategory(event.getPurchasingBookId(), event.getPurchasedBookId(),event.getCategory());
        emit().onResponse(new ResponseEvents(purchasingBook.getUncommittedChanges()));
    }
}
