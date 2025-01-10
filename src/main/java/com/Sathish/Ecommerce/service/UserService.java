package com.Sathish.Ecommerce.service;


import com.Sathish.Ecommerce.entity.users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.UserDetailsManager;

public interface UserService {
    void save(users theuser);
}
