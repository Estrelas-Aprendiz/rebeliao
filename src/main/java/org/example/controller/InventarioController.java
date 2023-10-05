package org.example.controller;

import org.example.repository.IInventarioRepository;
import org.example.service.InventarioService;

public class InventarioController implements IInventarioRepository {

    private InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService){
        this.inventarioService = inventarioService;
    }


    @Override
    public void visualizaInventario(Long idRebelde) {
        inventarioService.visualizaInventario(idRebelde);
    }

    @Override
    public void adicionarItemNoInventario(Long idRebelde, Long idItem) {
        inventarioService.adicionarItemNoInventario(idRebelde, idItem);
    }
}
