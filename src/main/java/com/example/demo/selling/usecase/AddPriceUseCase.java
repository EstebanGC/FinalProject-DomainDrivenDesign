package com.example.demo.selling.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.demo.selling.SellingBook;
import com.example.demo.selling.commands.AddPrice;

public class AddPriceUseCase extends UseCase<RequestCommand<AddPrice>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddPrice> addPriceRequestCommand) {
        var command = addPriceRequestCommand.getCommand();
        var sellingBook = SellingBook.from(command.getSellingBookId(), repository().getEventsBy(command.getSellingBookId().value()));
        sellingBook.addPrice(command.getSellingBookId(), command.getSellingId(), command.getPrice());
        emit().onResponse(new ResponseEvents(sellingBook.getUncommittedChanges()));
    }
}
