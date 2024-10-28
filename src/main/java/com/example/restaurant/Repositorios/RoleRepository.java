package com.example.restaurant.Repositorios;

import com.example.restaurant.Entidades.ERole;
import com.example.restaurant.Entidades.Role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}