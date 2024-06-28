package odk.tpspring.controller;

import odk.tpspring.model.Message;
import odk.tpspring.model.Ticket;
import odk.tpspring.service.MessageService;
import odk.tpspring.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    @GetMapping("/{id}")
    public Ticket findById(@PathVariable Long id) {
        return ticketService.findById(id);
    }

    @PostMapping("/create")
    public Ticket save(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @PutMapping("/update/{id}")
    public Ticket update(@PathVariable Long id, @RequestBody Ticket ticket) {
        return ticketService.update(id, ticket);
    }

    @PutMapping("/updateReponse/{id}")
    public Ticket updateReponse(@PathVariable Long id, @RequestBody Ticket ticket) {
        Ticket updatedTicket = ticketService.updateReponse(id, ticket);

        // Delegate email sending to MessageService
        String subject = "Réponse mise à jour pour le ticket ID: " + id;
        String text = "La réponse au ticket avec l'ID " + id + " a été mise à jour.";
        String destEmail = "boubacartraore8307@gmail.com"; // Example destination email

        messageService.sendEmail(subject, text, destEmail);

        return updatedTicket;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ticketService.delete(id);
    }
}
