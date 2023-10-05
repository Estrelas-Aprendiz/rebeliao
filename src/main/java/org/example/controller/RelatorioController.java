package org.example.controller;

import org.example.repository.IRelatorioRepository;
import org.example.service.RelatorioService;

public class RelatorioController implements IRelatorioRepository {

    private RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService){
        this.relatorioService = relatorioService;
    }


    @Override
    public int geraQtdTraidores() {
        return relatorioService.geraQtdTraidores();
    }

    @Override
    public int geraQtdRebeldes() {
        return relatorioService.geraQtdRebeldes();
    }

    @Override
    public double geraPorcentagemTraidores() {
        return relatorioService.geraPorcentagemTraidores();
    }

    @Override
    public double geraPorcentagemRebeldes() {
        return relatorioService.geraPorcentagemRebeldes();
    }
}
