package com.example.restaurant.Repositorios;

import com.example.restaurant.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {    
    Optional<Usuario> findByCorreo(String correo);
    Boolean existsByCorreo(String email);
}
