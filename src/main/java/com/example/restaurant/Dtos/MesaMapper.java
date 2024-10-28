package com.example.restaurant.Dtos;

import org.springframework.stereotype.Component;

import com.example.restaurant.Entidades.Mesa;

@Component
public class MesaMapper {
    public MesaDto toDTO(Mesa mesa) {
        MesaDto dto = new MesaDto();
        dto.setId(mesa.getId());
        dto.setCapacidad(mesa.getCapacidad());
        dto.setDisponible(mesa.isDisponible());
        dto.setUbicacion(mesa.getUbicacion());
        return dto;
    }
    public Mesa toEntity(MesaCreateDto dto) {
        Mesa mesa = new Mesa();
        mesa.setCapacidad(dto.getCapacidad());
        mesa.setDisponible(dto.isDisponible());
        mesa.setUbicacion(dto.getUbicacion());
        return mesa;
    }

}
