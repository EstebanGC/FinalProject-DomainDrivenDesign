package com.example.demo.selling.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.demo.selling.SellingBook;
import com.example.demo.selling.commands.AddClient;
import com.example.demo.selling.commands.AddPrice;

public class AddClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        var sellingBook = SellingBook.from(command.getSellingBookId(), repository().getEventsBy(command.getSellingBookId().value()));
        sellingBook.addClient(command.getSellingBookId(), command.getClientId(), command.getName());
        emit().onResponse(new ResponseEvents(sellingBook.getUncommittedChanges()));
    }

}
