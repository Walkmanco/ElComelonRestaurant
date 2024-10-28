package com.example.restaurant.Servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restaurant.Entidades.Usuario;
import com.example.restaurant.Repositorios.UsuarioRepository;



@Service
public class UserServiceImpl implements UserService{

    private final  UsuarioRepository userRepository;

    public UserServiceImpl(UsuarioRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Usuario creatUser(Usuario user) {
        Usuario userCopy= new Usuario(
                            user.getNombre()                                                    
                            ,user.getCorreo()                         
                            ,user.getContrasena()                            
                            ,user.getRoles());

        return userRepository.save(userCopy);
    }

    @Override
    public List<Usuario> showUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteAllUsers() {
       userRepository.deleteAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);        
    }
    
}
