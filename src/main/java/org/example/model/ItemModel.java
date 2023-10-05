package org.example.model;

import java.math.BigDecimal;

public class ItemModel {

    //Atributos
    private Long id_item;
    private String nome;
    private BigDecimal valor;


    //Construtores
    public ItemModel(Long id_item, String nome, BigDecimal valor) {
        this.id_item = id_item;
        this.nome = nome;
        this.valor = valor;
    }

    public ItemModel(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public ItemModel(){}

    //Getters e Setters
    public Long getId() {
        return id_item;
    }

    public void setId(Long id) {
        this.id_item = id_item;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
