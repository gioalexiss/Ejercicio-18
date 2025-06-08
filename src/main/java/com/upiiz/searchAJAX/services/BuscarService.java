package com.upiiz.searchAJAX.services;

import com.upiiz.searchAJAX.models.BuscarElemento;
import com.upiiz.searchAJAX.repositories.BuscarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarService {

    private final BuscarRepository buscarRepository;

    public BuscarService(BuscarRepository buscarRepository) {
        this.buscarRepository = buscarRepository;
    }

    public List<BuscarElemento> obtenerSugerencias(String query) {
        return buscarRepository.buscar(query);
    }
}
