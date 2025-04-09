package com.labs.ticketController.commands;

import java.util.Comparator;
import java.util.Map;

import com.labs.common.Command;
import com.labs.common.core.Ticket;
import com.labs.common.exceptions.KeyNotFoundException;
import com.labs.ticketController.CollectionManager;

public class FilterGreaterThanRefundableCommand implements Command {
    private CollectionManager collectionManager;
    private Boolean refundable;

    public FilterGreaterThanRefundableCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public Object execute() {
        return collectionManager.getAll().stream()
                .filter(ticket -> (ticket.refundable() == true && refundable == false))
                .sorted(Comparator.comparing(Ticket::name));
    }

    public void setArguments(Map<String, Object> data) throws KeyNotFoundException {
        if(!data.containsKey("refundable")) { throw new KeyNotFoundException("refundable"); }
        this.refundable = (Boolean)data.get("refundable");
    }
}

