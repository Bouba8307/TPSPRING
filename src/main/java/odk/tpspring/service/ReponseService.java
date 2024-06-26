package odk.tpspring.service;

import odk.tpspring.model.Reponse;
import java.util.List;

public interface ReponseService {
    Reponse creerReponse(Reponse reponse);
    List<Reponse> lireReponse();
    Reponse moddifierReponse(Long id, Reponse reponse);
    String suppReponse(Long id);
}
