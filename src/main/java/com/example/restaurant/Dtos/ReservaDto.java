package com.example.restaurant.Dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservaDto {
    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private int numPersonas;
    private Long idMesa; 
    private Long idCliente; 
    private Long idMenuPersonalizado;
}

