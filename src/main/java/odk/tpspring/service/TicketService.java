package odk.tpspring.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import odk.tpspring.model.Ticket;
import odk.tpspring.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
@AllArgsConstructor
public class TicketService {

    private TicketRepository ticketRepository;

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket update(Long id, Ticket ticket) {
        Ticket existingTicket = ticketRepository.findById(id).orElse(null);
        if (existingTicket != null) {
            existingTicket.setDescription(ticket.getDescription());
            existingTicket.setPriorite(ticket.getPriorite());
            existingTicket.setCategorie(ticket.getCategorie());
            existingTicket.setDateCreation(ticket.getDateCreation());
            existingTicket.setDateDernMod(ticket.getDateDernMod());
            existingTicket.setApprenant(ticket.getApprenant());
            return ticketRepository.save(existingTicket);
        } else {
            return null; // ou lance une exception appropriée
        }
    }

    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }
}
