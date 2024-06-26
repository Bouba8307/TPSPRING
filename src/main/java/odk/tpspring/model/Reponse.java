package odk.tpspring.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reponse")
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String corpReponse;

    @ManyToOne
    private Ticket ticket;

    }
