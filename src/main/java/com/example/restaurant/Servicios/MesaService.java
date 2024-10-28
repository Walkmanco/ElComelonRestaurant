package com.example.restaurant.Servicios;

import java.util.List;
import java.util.Optional;

import com.example.restaurant.Entidades.Mesa;


public interface MesaService {
    List<Mesa> showList();
    Mesa create(Mesa mesa);
    void delete(Long id);
    Mesa update(Long id, Mesa mesa);
    Optional<Mesa> findById(long id);
}
