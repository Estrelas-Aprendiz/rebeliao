package org.example.model;

public class RebeldeModel {

    //Atributos
    private Long id_rebelde;
    private String nome;
    private int idade;
    private String genero;
    private String localizacao;
    private boolean reb_ativo;
    private boolean traidor;

    //Construtores
    public RebeldeModel(Long id_rebelde, String nome, int idade, String genero, String localizacao, boolean reb_ativo, boolean traidor) {
        this.id_rebelde = id_rebelde;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.localizacao = localizacao;
        this.reb_ativo = reb_ativo;
        this.traidor = traidor;
    }

    public RebeldeModel(String nome, int idade, String genero, String localizacao) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.localizacao = localizacao;
    }

    public RebeldeModel(){}


    //Getter e Setter
    public Long getId() {
        return id_rebelde;
    }

    public void setId(Long id_rebelde) {
        this.id_rebelde = id_rebelde;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isRebAtivo() {
        return reb_ativo;
    }

    public void setRebAtivo(boolean rebAtivo) {
        this.reb_ativo = reb_ativo;
    }

    public boolean isTraidor() {
        return traidor;
    }

    public void setTraidor(boolean traidor) {
        this.traidor = traidor;
    }
}
