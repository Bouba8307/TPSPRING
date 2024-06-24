package odk.tpspring.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    private LocalDateTime dateCreation;
    private LocalDateTime dateDernMod;

    @ManyToOne
    private Apprenant apprenant;

    // Getters and setters
}
