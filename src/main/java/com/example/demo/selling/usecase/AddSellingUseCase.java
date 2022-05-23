package com.example.demo.selling.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.demo.selling.SellingBook;
import com.example.demo.selling.commands.AddClient;
import com.example.demo.selling.commands.AddSelling;

public class AddSellingUseCase extends UseCase<RequestCommand<AddSelling>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddSelling> addSellingRequestCommand) {
        var command = addSellingRequestCommand.getCommand();
        var sellingBook = SellingBook.from(command.getSellingBookId(), repository().getEventsBy(command.getSellingBookId().value()));
        sellingBook.addSelling(command.getSellingBookId(), command.getSellingId(), command.getName(), command.getCategory(), command.getPrice());
        emit().onResponse(new ResponseEvents(sellingBook.getUncommittedChanges()));
    }
}
