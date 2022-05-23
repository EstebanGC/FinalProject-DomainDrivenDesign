package com.example.demo.purchases.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.demo.purchases.PurchasingBook;
import com.example.demo.purchases.commands.AddProvider;



public class AddProviderUseCase extends UseCase<RequestCommand<AddProvider>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddProvider> addProviderRequestCommand) {
        var command = addProviderRequestCommand.getCommand();
        var purchasingBook = PurchasingBook.from(command.getPurchasingBookId(), repository().getEventsBy(command.getPurchasingBookId().value()));
        purchasingBook.addProvider(command.getPurchasingBookId(), command.getProviderId(), command.getName(), command.getContact());
        emit().onResponse(new ResponseEvents(purchasingBook.getUncommittedChanges()));
    }

}
