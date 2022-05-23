package com.example.demo.selling.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.demo.selling.SellingBook;
import com.example.demo.selling.commands.AddSeller;

public class AddSellerUseCase extends UseCase<RequestCommand<AddSeller>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddSeller> addSellerRequestCommand) {
        var command = addSellerRequestCommand.getCommand();
        var sellingBook = SellingBook.from(command.getSellingBookId(), repository().getEventsBy(command.getSellingBookId().value()));
        sellingBook.addSeller(command.getSellingBookId(), command.getSellerId(), command.getName(), command.getSoldBooks());
        emit().onResponse(new ResponseEvents(sellingBook.getUncommittedChanges()));
    }
}
