package org.example.service;

import org.example.model.RelatorioModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.connection.Conexao.getConnection;

public class RelatorioService {

    private Statement statement;
    private RelatorioModel relatorioModel;


    public RelatorioService(){
        try{
            statement = getConnection().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }

        relatorioModel = new RelatorioModel();
    }


    //Gera a quantidade de traídores existente dentro da base de dados
    public int geraQtdTraidores(){

        String sql = "SELECT count(traidor) AS qtd_traidores FROM rebeldes WHERE traidor IS TRUE;";

        try{

            ResultSet resultSet = statement.executeQuery(sql);
            int qtdTraidores = 0;

            while(resultSet.next()){
                qtdTraidores = resultSet.getInt("qtd_traidores");
            }
            return qtdTraidores;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    //Gera a quantidade de rebeldes existente dentro da base de dados
    public int geraQtdRebeldes(){

        String sql = "SELECT count(traidor) AS qtd_rebeldes FROM rebeldes WHERE traidor IS FALSE";

        try{
            ResultSet resultSet = statement.executeQuery(sql);
            int qtdTraidores = 0;

            while(resultSet.next()){
                qtdTraidores = resultSet.getInt("qtd_rebeldes");
            }
            return qtdTraidores;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    //Gera a porcentagem de traidores existente no base de dados
    public double geraPorcentagemTraidores(){
        relatorioModel.setPorcentagemTraidores(((double) geraQtdTraidores() / (geraQtdRebeldes() + geraQtdTraidores())) * 100);
        return relatorioModel.getPorcentagemTraidores();
    }

    //Gera a porcentagem de rebeldes existente no base de dados
    public double geraPorcentagemRebeldes(){
        relatorioModel.setPorcentagemRebeldes(((double) geraQtdRebeldes() / (geraQtdRebeldes() + geraQtdTraidores())) * 100);
        return relatorioModel.getPorcentagemRebeldes();
    }

}
