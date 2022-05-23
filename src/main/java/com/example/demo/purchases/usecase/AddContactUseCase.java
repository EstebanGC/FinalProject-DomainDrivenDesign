package com.example.demo.purchases.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.demo.purchases.PurchasingBook;
import com.example.demo.purchases.commands.AddContact;
import com.example.demo.purchases.commands.AddProvider;

public class AddContactUseCase extends UseCase<RequestCommand<AddContact>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddContact> addContactRequestCommand) {
        var command = addContactRequestCommand.getCommand();
        var purchasingBook = PurchasingBook.from(command.getPurchasingBookId(), repository().getEventsBy(command.getPurchasingBookId().value()));
        purchasingBook.addContact(command.getPurchasingBookId(), command.getProviderId(), command.getContact());
        emit().onResponse(new ResponseEvents(purchasingBook.getUncommittedChanges()));
    }

}
