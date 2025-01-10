package com.Sathish.Ecommerce.dao;

import com.Sathish.Ecommerce.entity.authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<authority, Integer> {
}
