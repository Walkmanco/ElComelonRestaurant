package com.example.restaurant.Servicios;

import com.example.restaurant.Dtos.ReservaDto;
import com.example.restaurant.Entidades.Reserva;
import com.example.restaurant.Entidades.Usuario;
import com.example.restaurant.Entidades.EstadoReserva;
import com.example.restaurant.Entidades.MenuPersonalizado;
import com.example.restaurant.Entidades.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restaurant.Repositorios.ReservaRepository;
import com.example.restaurant.Repositorios.UsuarioRepository;
import com.example.restaurant.Repositorios.MesaRepository;
import com.example.restaurant.Repositorios.MenuPersonalizadoRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;
    private UsuarioRepository usuarioRepository;
    private MesaRepository mesaRepository;
    @Autowired
    private MenuPersonalizadoRepository menuPersonalizadoRepository;

    public Reserva createReservation(ReservaDto reservaDto) {
       Mesa mesa = mesaRepository.findById(reservaDto.getIdMesa())
            .orElseThrow(() -> new RuntimeException("Mesa no encontrada"));
    if (!mesa.isDisponible()) {
        throw new RuntimeException("Mesa no disponible");
    }

    Reserva reserva = new Reserva();
    reserva.setMesa(mesa);
    reserva.setFecha_reserva(reservaDto.getFechaReserva());
    reserva.setHora_reserva(reservaDto.getHoraReserva());
    reserva.setNum_personas(reservaDto.getNumPersonas());
    Usuario cliente = usuarioRepository.findById(reservaDto.getIdCliente())
            .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado con id: " + reservaDto.getIdCliente()));
    reserva.setCliente(cliente);
    reserva.setEstado(EstadoReserva.ACTIVA);

    if (reservaDto.getIdMenuPersonalizado() != null) {
        MenuPersonalizado menu = menuPersonalizadoRepository.findById(reservaDto.getIdMenuPersonalizado())
                .orElseThrow(() -> new RuntimeException("Menú personalizado no encontrado"));
        reserva.setMenuPersonalizado(menu);
    }
    
    mesa.setDisponible(false);
    mesaRepository.save(mesa);
    return reservaRepository.save(reserva);
    }

    public List<Reserva> getReservationsByUserId(Long userId) {
        return reservaRepository.findByCliente_Id(userId); 
    }


public void cancelarReserva(Long id) {
    Reserva reserva = reservaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    reserva.setEstado(EstadoReserva.CANCELADA);

    Mesa mesa = reserva.getMesa();
    mesa.setDisponible(true);
    mesaRepository.save(mesa);
    reservaRepository.save(reserva);
}
public ReservaDto toDTO(Reserva reserva) {
    ReservaDto dto = new ReservaDto();
    dto.setFechaReserva(reserva.getFecha_reserva());
    dto.setHoraReserva(reserva.getHora_reserva());
    dto.setNumPersonas(reserva.getNum_personas());
    dto.setIdMesa(reserva.getMesa().getId());
    dto.setIdCliente(reserva.getCliente().getId());
    return dto;
}
}