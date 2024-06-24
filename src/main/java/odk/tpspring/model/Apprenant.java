package odk.tpspring.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Data
@Entity
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    @OneToMany(mappedBy = "apprenant")
    private List<Ticket> tickets;

    // Getters and Setters
}

