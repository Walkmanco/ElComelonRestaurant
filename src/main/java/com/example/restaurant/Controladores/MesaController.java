package com.example.restaurant.Controladores;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.Dtos.MesaCreateDto;
import com.example.restaurant.Dtos.MesaDto;
import com.example.restaurant.Dtos.MesaMapper;
import com.example.restaurant.Entidades.Mesa;
import com.example.restaurant.Servicios.MesaService;

@RestController
@RequestMapping("/mesas")
public class MesaController {
    @Autowired
    private MesaService mesaService;

    @Autowired
    private MesaMapper mesaMapper;

    @GetMapping
    public ResponseEntity<List<MesaDto>> obtenerMesas() {
        List<Mesa> mesas = mesaService.showList();
        List<MesaDto> mesasDto = mesas.stream().map(mesaMapper::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(mesasDto, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<MesaDto> crearMesa(@RequestBody MesaCreateDto mesaCreateDto) {
        Mesa mesa = mesaService.create(mesaMapper.toEntity(mesaCreateDto));
        MesaDto mesaDto = mesaMapper.toDTO(mesa);
        return new ResponseEntity<>(mesaDto, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<MesaDto> actualizarMesa(@PathVariable Long id, @RequestBody MesaCreateDto mesaCreateDto) {
        Mesa mesa = mesaService.update(id, mesaMapper.toEntity(mesaCreateDto));
        MesaDto mesaDto = mesaMapper.toDTO(mesa);
        return new ResponseEntity<>(mesaDto, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarMesa(@PathVariable Long id) {
        mesaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaDto> obtenerMesaPorId(@PathVariable Long id) {
        Mesa mesa = mesaService.findById(id).orElseThrow(() -> new NoSuchElementException("Mesa no encontrada con id: " + id));
        MesaDto mesaDto = mesaMapper.toDTO(mesa);
        return new ResponseEntity<>(mesaDto, HttpStatus.OK);
    }
}
