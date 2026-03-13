package com.ejemploreservas.canchareservas.controller;

import com.ejemploreservas.canchareservas.model.Cancha;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/canchas")
public class CanchaController {

    private List<Cancha> canchas = new ArrayList<>();

    // GET /canchas
    @GetMapping
    public List<Cancha> obtenerCanchas() {
        return canchas;
    }

    // GET /canchas/{id}
    @GetMapping("/{id}")
    public Cancha obtenerCanchaPorId(@PathVariable Long id) {

        for (Cancha cancha : canchas) {
            if (cancha.getId().equals(id)) {
                return cancha;
            }
        }

        return null;
    }

    // POST /canchas
    @PostMapping
    public Cancha agregarCancha(@RequestBody Cancha cancha) {
        canchas.add(cancha);
        return cancha;
    }
}