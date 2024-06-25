package odk.tpspring.service.serviceimpl;

import lombok.Data;
import odk.tpspring.model.Reponse;
import odk.tpspring.repository.ReponseRepository;
import odk.tpspring.service.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ReponseServiceImplement implements ReponseService {
    @Autowired
    ReponseRepository reponseRepository ;


    @Override
    public Reponse creerReponse(Reponse reponse) {
        return null;
    }

    @Override
    public List<Reponse> lireReponse() {
        return reponseRepository.findAll();
    }

    @Override
    public Reponse moddifierReponse(Long id, Reponse reponse) {
        return reponseRepository.findById(id)
                .map((re)->{
                    re.setCorpReponse(re.getCorpReponse());
                    re.setFormateur(re.getFormateur());
                    re.setTicket(re.getTicket());
                    return reponseRepository.save(re);
                }).orElseThrow(()->new RuntimeException("Role introuvable"));
    }

    @Override
    public String suppReponse(Long id) {
        reponseRepository.deleteById(id);
        return "Reponse supprimer";
    }
}