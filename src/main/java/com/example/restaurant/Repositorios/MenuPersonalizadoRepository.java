package com.example.restaurant.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.restaurant.Entidades.MenuPersonalizado;

@Repository
public interface MenuPersonalizadoRepository extends JpaRepository<MenuPersonalizado, Long> {
}
