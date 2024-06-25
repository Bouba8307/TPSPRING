package odk.tpspring.service;

import odk.tpspring.model.Admin;
import odk.tpspring.model.User;
import odk.tpspring.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserService userService; // Assuming you have a UserService for creating users

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin save(Admin admin) {
        // Save the user first
        User savedUser = userService.createUser(admin);

        // Set the ID of the admin to the user's ID
        admin.setId(savedUser.getId());

        // Now save the admin
        return adminRepository.save(admin);
    }

    public void delete(Long id) {
        adminRepository.deleteById(id);
    }
}
