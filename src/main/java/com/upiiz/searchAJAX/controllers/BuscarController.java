package com.upiiz.searchAJAX.controllers;

import com.upiiz.searchAJAX.models.BuscarElemento;
import com.upiiz.searchAJAX.services.BuscarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class BuscarController {

    private final BuscarService buscarService;

    public BuscarController(BuscarService buscarService) {
        this.buscarService = buscarService;
    }
    @GetMapping("/suggestions")
    public List<BuscarElemento> obtenerSugerencias(@RequestParam String query) {
        return buscarService.obtenerSugerencias(query);
    }
}
