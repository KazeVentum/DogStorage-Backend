package com.uniminuto.dogstorage.api.controller;

import com.uniminuto.dogstorage.domain.security.JWTAuthtenticationConfig;
import com.uniminuto.dogstorage.persistence.entity.Admin;
import com.uniminuto.dogstorage.domain.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public String login(@RequestBody Admin loginData) {
        Admin admin = adminRepository.findByUsername(loginData.getUsername());
        if (admin != null && admin.getPassword().equals(loginData.getPassword())) {
            String token = jwtAuthtenticationConfig.getJWTToken(loginData.getUsername());
            return token;
        } else {
            throw new RuntimeException("Invalid Information");
        }
    }
}
