package com.example.restaurant.Servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.restaurant.Entidades.Usuario;
import com.example.restaurant.Repositorios.UsuarioRepository;






@Service
public class UserDetailsServicesImpl implements UserDetailsService{
    @Autowired
    UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = userRepository.findByCorreo(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

        return UserDetailsImpl.build(user);
    }
    
}
