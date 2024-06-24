package odk.tpspring.repository;

import odk.tpspring.model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    Apprenant findByEmail(String email);
}
