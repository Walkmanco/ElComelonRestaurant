package com.example.restaurant.Servicios;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.restaurant.Entidades.Mesa;
import com.example.restaurant.Repositorios.MesaRepository;

@Service
public class MesaServiceImpl implements MesaService{
    private final MesaRepository mesaR;

    public MesaServiceImpl(MesaRepository mesaR) {
        this.mesaR = mesaR;
    }

    @Override
    public Mesa create(Mesa mesa) {
        Mesa table  = new Mesa(null, mesa.getCapacidad(), 
                mesa.isDisponible(), mesa.getUbicacion());
        return mesaR.save(table);
    }
    @Override
    public void delete(Long id) {
         if (!mesaR.existsById(id)) {
            throw new NoSuchElementException("Mesa no encontrada con id: " + id);
        }
        mesaR.deleteById(id);
    }
    @Override
    public List<Mesa> showList() {
        return mesaR.findAll();
    }

    @Override
    public Optional<Mesa> findById(long num_Mesa) {
        return mesaR.findById(num_Mesa);
    }
  
    public Mesa update(Long id, Mesa mesa) {
        Optional<Mesa> existingMesaOpt = mesaR.findById(id);
        if (existingMesaOpt.isPresent()) {
            Mesa existingMesa = existingMesaOpt.get();
            existingMesa.setCapacidad(mesa.getCapacidad());
            existingMesa.setUbicacion(mesa.getUbicacion());
            existingMesa.setDisponible(mesa.isDisponible());
            return mesaR.save(existingMesa); 
        } else {
            throw new NoSuchElementException("Mesa no encontrada con id: " + id);
        }
    }
}
