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
    public Ticket updateReponse(@PathVariable Long id,@RequestBody Ticket ticket) {
        return  ticketService.updateReponse(id, ticket);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ticketService.delete(id);
    }
}
