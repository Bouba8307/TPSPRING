package odk.tpspring.service;

import odk.tpspring.model.Admin;
import odk.tpspring.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    public void delete(Long id) {
        adminRepository.deleteById(id);
    }
}

