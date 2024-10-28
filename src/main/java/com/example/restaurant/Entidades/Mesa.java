package com.example.restaurant.Entidades;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Mesas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//numero de mesa

    @Column(nullable = false)
    private int capacidad;
    @Column(nullable = false)
    private boolean disponible;//si o no

    @Enumerated(EnumType.STRING)
    private UbicacionMesa ubicacion;

    @OneToMany(mappedBy = "mesa")
    private Set<Reserva> reservas;

    public Mesa(Long id, int capacidad, boolean disponible, 
                UbicacionMesa ubicacion) {
        this.id = id;
        this.capacidad = capacidad;
        this.disponible = disponible;
        this.ubicacion = ubicacion;
    }

    public Mesa UpdateWidth(Mesa mesa){
        return new Mesa(this.id, 
                        mesa.getCapacidad(), 
                        mesa.isDisponible(), 
                        mesa.getUbicacion());
    }

}
