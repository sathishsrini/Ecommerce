package com.Sathish.Ecommerce.service;

import com.Sathish.Ecommerce.dao.UserRepository;
import com.Sathish.Ecommerce.entity.users;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void save(users theuser) {
        userRepository.save(theuser);
    }
}
