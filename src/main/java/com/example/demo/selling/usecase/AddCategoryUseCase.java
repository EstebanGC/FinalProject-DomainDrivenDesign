package com.example.demo.selling.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.demo.selling.commands.AddCategory;
import com.example.demo.selling.SellingBook;

public class AddCategoryUseCase extends UseCase<RequestCommand<AddCategory>, ResponseEvents>  {
    @Override
    public void executeUseCase(RequestCommand<AddCategory> addCategoryRequestCommand) {
        var command = addCategoryRequestCommand.getCommand();
        var sellingBook = SellingBook.from(command.getSellingBookId(), repository().getEventsBy(command.getSellingBookId().value()));
        sellingBook.addCategory(command.getSellingBookId(), command.getSellingId(), command.getCategory());
        emit().onResponse(new ResponseEvents(sellingBook.getUncommittedChanges()));
    }
}
