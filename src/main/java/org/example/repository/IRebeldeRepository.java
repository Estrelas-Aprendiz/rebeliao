package org.example.repository;

import org.example.model.RebeldeModel;

import java.util.List;

public interface IRebeldeRepository {

    public abstract void adicionaRebelde(RebeldeModel rebeldeModel);
    public abstract List<RebeldeModel> buscaTodosRebeldes();
    public abstract RebeldeModel buscaRebeldePorId(Long id_rebelde);
    public abstract void atualizaLocalizacao(Long id_rebelde, String localizacao);//*
    public abstract void deletaRebelde(Long id_rebelde);
    public abstract void reportarRebelde(Long id_rebelde, Long idReportado); //*
    public abstract boolean alterarStatusRebelde(Long id_rebelde);


}
