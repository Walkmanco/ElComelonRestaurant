package com.example.restaurant.Dtos;

import com.example.restaurant.Entidades.UbicacionMesa;

import lombok.Data;

@Data
public class MesaDto {
    private Long id;
    private int capacidad;
    private boolean disponible;
    private UbicacionMesa ubicacion;

}
