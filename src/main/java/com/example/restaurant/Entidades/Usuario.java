package com.example.restaurant.Entidades;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "correo")
})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String contrasena;

    @OneToMany (mappedBy = "cliente")
    private Set<Reserva> reservas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    public Usuario(Long id, String nombre, String correo, String contrasena, Set<Reserva> reservas) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.reservas = reservas;
    }


    public Usuario(String nombre, String correo, String contrasena, Set<Role> roles) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.roles = roles;
    }

    public Usuario UpdateWidth(Usuario oldUsuario ){
        return new Usuario(this.id, oldUsuario.getNombre(), oldUsuario.getCorreo(), oldUsuario.getContrasena(), oldUsuario.getReservas());
    }

    public Usuario(String name, String email, String password) {
        this.nombre = name;
        this.correo = email;
        this.contrasena = password;
    }

}
