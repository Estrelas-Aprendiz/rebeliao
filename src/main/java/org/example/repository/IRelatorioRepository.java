package org.example.repository;

public interface IRelatorioRepository {

    public abstract int geraQtdTraidores();
    public abstract int geraQtdRebeldes();
    public abstract double geraPorcentagemTraidores();
    public abstract double geraPorcentagemRebeldes();

}
