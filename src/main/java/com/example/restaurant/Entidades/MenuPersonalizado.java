package com.example.restaurant.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MenusPersonalizados")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MenuPersonalizado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;
    
    @Column(nullable = false)
    private Double precio;
}
