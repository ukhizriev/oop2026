package org.example.helpdesk.repository;

import org.example.helpdesk.model.Ticket;
import org.example.helpdesk.model.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByOrderByCreatedAtDesc();

    List<Ticket> findByStatus(TicketStatus status);

    List<Ticket> findByCustomerNameContainingIgnoreCase(String customerName);
}