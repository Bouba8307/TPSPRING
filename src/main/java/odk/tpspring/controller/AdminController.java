package odk.tpspring.controller;

import odk.tpspring.model.Admin;
import odk.tpspring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> findAll() {
        return adminService.findAll();
    }

    @GetMapping("/{id}")
    public Admin findById(@PathVariable Long id) {
        return adminService.findById(id);
    }

    @PostMapping
    public Admin save(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        adminService.delete(id);
    }
}

