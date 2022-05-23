package com.example.demo.purchases.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.demo.purchases.PurchasingBook;
import com.example.demo.purchases.commands.AddPurchase;

public class AddPurchaseUseCase extends UseCase<RequestCommand<AddPurchase>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddPurchase> addPurchaseRequestCommand) {
        var command = addPurchaseRequestCommand.getCommand();
        var purchasingBook = PurchasingBook.from(command.getPurchasingBookId(), repository().getEventsBy(command.getPurchasingBookId().value()));
        purchasingBook.addPurchase(command.getPurchasingBookId(), command.getPurchaseId(), command.getNumberOfBooks(), command.getTotalPrice());
        emit().onResponse(new ResponseEvents(purchasingBook.getUncommittedChanges()));
    }
}
