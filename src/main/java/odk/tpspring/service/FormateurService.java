package odk.tpspring.service;

import odk.tpspring.model.Formateur;
import odk.tpspring.repository.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormateurService {

    @Autowired
    private FormateurRepository formateurRepository;

    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }

    public Formateur findById(Long id) {
        return formateurRepository.findById(id).orElse(null);
    }

    public Formateur save(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    public void delete(Long id) {
        formateurRepository.deleteById(id);
    }
}
