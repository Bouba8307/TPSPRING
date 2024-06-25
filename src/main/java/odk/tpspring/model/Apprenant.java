package odk.tpspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

import java.util.List;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "user_id") // Mapping de la clé étrangère dans la table
public class Apprenant extends User {

    private String email;
    private String telephone;

    // Add any additional properties specific to Apprenant

    // Getters and setters
}
