package odk.tpspring.service;

import odk.tpspring.model.Formateur;
import odk.tpspring.model.User;
import odk.tpspring.repository.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormateurService {

    @Autowired
    private FormateurRepository formateurRepository;

    @Autowired
    private UserService userService; // Assuming you have a UserService for creating users

    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }

    public Formateur findById(Long id) {
        return formateurRepository.findById(id).orElse(null);
    }

    public Formateur save(Formateur formateur) {
        // Save the user first
        User savedUser = userService.createUser(formateur);

        // Set the ID of the formateur to the user's ID
        formateur.setId(savedUser.getId());

        // Now save the formateur
        return formateurRepository.save(formateur);
    }

    public void delete(Long id) {
        formateurRepository.deleteById(id);
    }
}
