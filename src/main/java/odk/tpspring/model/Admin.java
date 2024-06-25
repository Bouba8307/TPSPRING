package odk.tpspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "user_id") // Mapping de la clé étrangère dans la table
public class Admin extends User {

    private String email;
    private String telephone;

    // Getters and setters
}
