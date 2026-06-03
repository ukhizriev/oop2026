package org.example.helpdesk.service;

import org.example.helpdesk.dto.TicketCreateDto;
import org.example.helpdesk.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket createTicket(TicketCreateDto ticketCreateDto);

    List<Ticket> getAllTickets();

    Ticket getTicketById(Long id);
}
