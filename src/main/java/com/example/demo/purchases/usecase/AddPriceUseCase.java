package com.example.demo.purchases.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.demo.purchases.PurchasingBook;

import com.example.demo.purchases.commands.AddPrice;

public class AddPriceUseCase extends UseCase<RequestCommand<AddPrice>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPrice> addPriceRequestCommand) {
        var command = addPriceRequestCommand.getCommand();
        var purchasingBook = PurchasingBook.from(command.getPurchasingBookId(), repository().getEventsBy(command.getPurchasingBookId().value()));
        purchasingBook.addPrice(command.getPurchasingBookId(), command.getPurchasedBookId(), command.getPrice());
        emit().onResponse(new ResponseEvents(purchasingBook.getUncommittedChanges()));
    }
}
