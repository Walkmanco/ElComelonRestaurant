package com.example.restaurant.Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "Reservas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha_reserva;
    @Column(nullable = false)
    private LocalTime hora_reserva;
    @Column(nullable = false)
    private int num_personas;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuPersonalizado menuPersonalizado;

    public Reserva(Usuario cliente, Mesa mesa) {
        this.cliente = cliente;
        this.mesa = mesa;
    }

}
