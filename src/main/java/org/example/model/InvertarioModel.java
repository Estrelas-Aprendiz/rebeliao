package org.example.model;

import java.util.List;

public class InvertarioModel {

    //Atributos
    private Long id;
    private List<ItemModel> itens;

    //Construtores
    public InvertarioModel(Long id, List<ItemModel> itens) {
        this.id = id;
        this.itens = itens;
    }

    public InvertarioModel(){}


    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemModel> getItens() {
        return itens;
    }

    public void setItens(List<ItemModel> itens) {
        this.itens = itens;
    }
}
