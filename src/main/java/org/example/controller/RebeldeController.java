package org.example.controller;

import org.example.model.RebeldeModel;
import org.example.repository.IRebeldeRepository;
import org.example.service.RebeldeService;

import java.util.List;

public class RebeldeController implements IRebeldeRepository {


    private RebeldeService rebeldeService;

    public RebeldeController(RebeldeService rebeldeService){
        this.rebeldeService = rebeldeService;
    }

    //Esse método é sobrescrito chamando os métodos dentro da classe de serviço
    @Override
    public void adicionaRebelde(RebeldeModel rebeldeModel) {
        rebeldeService.adicionaRebelde(rebeldeModel);
    }

    @Override
    public List<RebeldeModel> buscaTodosRebeldes() {
        return rebeldeService.buscaTodosRebeldes();
    }

    @Override
    public RebeldeModel buscaRebeldePorId(Long id_rebelde) {
        return null;
    }

    @Override
    public void atualizaLocalizacao(Long id_rebelde, String localizacao) {
        rebeldeService.atualizaLocalizacao(id_rebelde, localizacao);
    }

    @Override
    public void deletaRebelde(Long id_rebelde) {

    }

    @Override
    public void reportarRebelde(Long id_rebelde, Long idReportado) {
        rebeldeService.reportaRebelde(id_rebelde, idReportado);
    }

    @Override
    public boolean alterarStatusRebelde(Long id_rebelde) {
        return rebeldeService.alteraStatusTraidor(id_rebelde);
    }
}
