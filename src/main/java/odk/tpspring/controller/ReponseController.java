package odk.tpspring.controller;

import lombok.Data;
import odk.tpspring.model.Reponse;
import odk.tpspring.service.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reponse")
@Data
public class ReponseController {
    @Autowired
    private final ReponseService reponseService;
    @PostMapping("/creationReponse")
    public Reponse creation(@RequestBody Reponse reponse){
        return reponseService.creerReponse(reponse);
    }


    @GetMapping("/Liste")
    public List<Reponse> read(){
        return reponseService.lireReponse();
    }
    @PutMapping("modifier/{id}")
    public Reponse modif(@PathVariable long id,@RequestBody Reponse reponse){
        return reponseService.moddifierReponse(id,reponse);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprim(@PathVariable long id){
        return reponseService.suppReponse(id);
    }
}