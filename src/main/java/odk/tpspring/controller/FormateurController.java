package odk.tpspring.controller;

import odk.tpspring.model.Formateur;
import odk.tpspring.repository.FormateurRepository;
import odk.tpspring.service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formateurs")
public class FormateurController {
    @Autowired
    private FormateurService formateurService;

    @Autowired
    private FormateurRepository formateurRepository;

    @GetMapping
    public List<Formateur> findAll() {
        return formateurService.findAll();
    }

    @GetMapping("/{id}")
    public Formateur findById(@PathVariable Long id) {
        return formateurService.findById(id);
    }

    @PostMapping
    public Formateur save(@RequestBody Formateur formateur) {
        return formateurService.save(formateur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        formateurService.delete(id);
    }
}

