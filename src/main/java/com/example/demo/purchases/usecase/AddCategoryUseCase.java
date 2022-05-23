package com.example.demo.purchases.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.demo.purchases.PurchasingBook;
import com.example.demo.purchases.commands.AddCategory;
import com.example.demo.purchases.commands.AddContact;

public class AddCategoryUseCase extends UseCase<RequestCommand<AddCategory>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddCategory> addCategoryRequestCommand) {
        var command = addCategoryRequestCommand.getCommand();
        var purchasingBook = PurchasingBook.from(command.getPurchasingBookId(), repository().getEventsBy(command.getPurchasingBookId().value()));
        purchasingBook.addCategory(command.getPurchasingBookId(), command.getPurchasedBookId(), command.getCategory());
        emit().onResponse(new ResponseEvents(purchasingBook.getUncommittedChanges()));
    }
}
