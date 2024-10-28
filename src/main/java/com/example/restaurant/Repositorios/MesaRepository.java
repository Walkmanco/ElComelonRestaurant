package com.example.restaurant.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurant.Entidades.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    //si se implementarán funciones de busqueda, aquí se definirian.
}
    
