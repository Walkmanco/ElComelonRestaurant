package com.example.restaurant.Servicios;

import java.util.List;

import com.example.restaurant.Entidades.Usuario;




public interface UserService {
    Usuario creatUser(Usuario user);
    List<Usuario> showUsers();
    void deleteAllUsers();
    void deleteUserById(Long id);
}
