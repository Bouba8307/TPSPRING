package odk.tpspring.repository;

import odk.tpspring.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByApprenantId(Long apprenantId);
    // Ajoutez des méthodes de recherche spécifiques si nécessaire
}
