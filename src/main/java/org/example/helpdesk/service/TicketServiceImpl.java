package org.example.helpdesk.service;
import org.example.helpdesk.dto.TicketCreateDto;
import org.example.helpdesk.model.Ticket;
import org.example.helpdesk.model.TicketStatus;
import org.example.helpdesk.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(TicketCreateDto ticketCreateDto) {
        Ticket ticket = new Ticket();
        ticket.setCustomerName(ticketCreateDto.getCustomerName());
        ticket.setTitle(ticketCreateDto.getTitle());
        ticket.setDescription(ticketCreateDto.getDescription());
        ticket.setStatus(TicketStatus.NEW);
        ticket.setCreatedAt(LocalDateTime.now());

        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Заявка не найдена: " + id));
    }
}
