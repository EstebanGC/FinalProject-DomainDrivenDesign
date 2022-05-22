package com.example.demo.selling.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.demo.purchases.commands.AddCategory;
import com.example.demo.selling.Selling;
import com.example.demo.selling.SellingBook;

public class AddCategoryUseCase extends UseCase<RequestCommand<AddCategory>, ResponseEvents>  {
    @Override
    public void executeUseCase(RequestCommand<AddCategory> addCategoryRequestCommand) {
        var command = addCategoryRequestCommand.getCommand();
        var sellingBook = SellingBook.from(command., retrieveEvents(command.sellingBookId().value()));
        sellingBook.addCategory(command.disResId(), command.disabled(), command.payments());
        emit().onResponse(new ResponseEvents(sellings.getUncommittedChanges()));

    }
}
