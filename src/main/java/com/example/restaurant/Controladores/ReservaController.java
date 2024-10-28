package com.example.restaurant.Controladores;

import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.Dtos.ReservaDto;
import com.example.restaurant.Entidades.Reserva;
import com.example.restaurant.Servicios.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("/crear")
    public ResponseEntity<ReservaDto> crearReserva(@RequestBody ReservaDto reservaDto) {
        Reserva reserva = reservaService.createReservation(reservaDto);
        ReservaDto reservaDto2 = reservaService.toDTO(reserva);
        return new ResponseEntity<>(reservaDto2, HttpStatus.CREATED);
    }

    @DeleteMapping("/cancelar/{id}")
    public ResponseEntity<Void> cancelarReserva(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ReservaDto>> obtenerReservasPorUsuario(@PathVariable Long usuarioId) {
        List<Reserva> reservas = reservaService.getReservationsByUserId(usuarioId);
        List<ReservaDto> reservasDto = reservas.stream().map(reservaService::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(reservasDto, HttpStatus.OK);
    }
}
