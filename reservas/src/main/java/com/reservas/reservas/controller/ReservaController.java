package com.reservas.reservas.controller;

import com.reservas.reservas.model.Reserva;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private List<Reserva> reservas = new ArrayList<>();

    @GetMapping
    public List<Reserva> obtenerReservas() {
        return reservas;
    }

    @PostMapping
    public Reserva agregarReserva(@RequestBody Reserva reserva) {
        reservas.add(reserva);
        return reserva;
    }

    @GetMapping("/cancha/{id}")
    public List<Reserva> reservasPorCancha(@PathVariable Long id) {

        List<Reserva> resultado = new ArrayList<>();

        for (Reserva r : reservas) {
            if (r.getCanchaId().equals(id)) {
                resultado.add(r);
            }
        }

        return resultado;
    }
}