package odk.tpspring.service;

import odk.tpspring.model.Apprenant;
import odk.tpspring.repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApprenantService {
    @Autowired
    private ApprenantRepository apprenantRepository;

    public List<Apprenant> findAll() {
        return apprenantRepository.findAll();
    }

    public Apprenant findById(Long id) {
        return apprenantRepository.findById(id).orElse(null);
    }

    public Apprenant save(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    public void delete(Long id) {
        apprenantRepository.deleteById(id);
    }

}

