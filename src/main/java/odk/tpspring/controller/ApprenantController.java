package odk.tpspring.controller;

import odk.tpspring.model.Apprenant;
import odk.tpspring.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apprenants")
public class ApprenantController {
    @Autowired
    private ApprenantService apprenantService;

    @GetMapping("/read")
    public List<Apprenant> findAll() {
        return apprenantService.findAll();
    }

    @GetMapping("/{id}")
    public Apprenant findById(@PathVariable Long id) {
        return apprenantService.findById(id);
    }

    @PostMapping
    public Apprenant save(@RequestBody Apprenant apprenant) {
        return apprenantService.save(apprenant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        apprenantService.delete(id);
    }
}

