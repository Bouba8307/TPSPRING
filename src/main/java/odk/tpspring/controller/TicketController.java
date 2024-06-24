package odk.tpspring.controller;

import odk.tpspring.model.Ticket;
import odk.tpspring.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_APPRENANT', 'ROLE_FORMATEUR', 'ROLE_ADMIN')")
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_APPRENANT', 'ROLE_FORMATEUR', 'ROLE_ADMIN')")
    public Ticket findById(@PathVariable Long id) {
        return ticketService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_APPRENANT')")
    public Ticket save(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_APPRENANT')")
    public void delete(@PathVariable Long id) {
        ticketService.delete(id);
    }
}
