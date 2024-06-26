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

    public Ticket updateReponse(Long id, Ticket ticket) {
        return ticketRepository.findById(id)
                .map(p->{
                    p.setReponse(ticket.getReponse());
                    return ticketRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("erreur"));
    }

    public Ticket update(Long id, Ticket ticket) {
        return ticketRepository.findById(id)
                .map(p->{
                    p.setDescription(ticket.getDescription());
                    p.setPriorite(ticket.getPriorite());
                    p.setCategorie(ticket.getCategorie());
                    p.setDateCreation(ticket.getDateCreation());
                    p.setDateDernMod(ticket.getDateDernMod());
                    p.setReponse(ticket.getReponse());
                    return ticketRepository.save(p);
        }).orElseThrow(()-> new RuntimeException("Erreur"));
    }

    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }
}
