package com.uniminuto.dogstorage.api.controller;

import com.uniminuto.dogstorage.persistence.entity.Admin;
import com.uniminuto.dogstorage.domain.service.implementation.AdminImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class AdminController {

    @Autowired
    private AdminImplementation adminService;
    @Autowired
    public AdminController(AdminImplementation adminInterfaceImpl) {
        this.adminService = adminService;
    }
    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Object id) {
        return adminService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin adminSave) {
        return adminService.save(adminSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        return adminService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin( @PathVariable Object id, @RequestBody Admin adminUpdate) {
        return adminService.update(id, adminUpdate);
    }


} 