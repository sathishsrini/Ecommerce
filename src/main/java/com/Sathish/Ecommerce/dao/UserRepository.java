package com.Sathish.Ecommerce.dao;

import com.Sathish.Ecommerce.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<users, Integer> {
    Optional<users> findByUsername(String username);
}
