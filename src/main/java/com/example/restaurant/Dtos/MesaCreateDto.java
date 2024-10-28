package com.example.restaurant.Dtos;

import com.example.restaurant.Entidades.UbicacionMesa;

import lombok.Data;

@Data
public class MesaCreateDto {
    private boolean  disponible;
    private int capacidad;
    private UbicacionMesa ubicacion;  
}
