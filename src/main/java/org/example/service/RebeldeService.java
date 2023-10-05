package org.example.service;

import org.example.model.RebeldeModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.connection.Conexao.getConnection;
public class RebeldeService {

    private Statement statement;
    private RebeldeModel rebeldeModel;
    private List<RebeldeModel> rebeldes;


    public RebeldeService(){
        rebeldes = new ArrayList<>();

        try{
            statement = getConnection().createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Adiciona rebelde na base de dados
    public void adicionaRebelde(RebeldeModel rebeldeModel){
        String sql = String.format("INSERT INTO rebeldes (nome, idade, genero, localizacao," +
                        "reb_ativo, traidor) VALUES ('%s', '%d', '%s', '%s', '%b', '%b')", rebeldeModel.getNome(), rebeldeModel.getIdade(),
                rebeldeModel.getGenero(), rebeldeModel.getLocalizacao(), rebeldeModel.isRebAtivo(), rebeldeModel.isTraidor());

        try{
            statement.executeUpdate(sql);
            System.out.println("Rebelde " + rebeldeModel.getNome() + " foi adicionado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //Busca todos os rebeldes existentes na base de dados
    public List<RebeldeModel> buscaTodosRebeldes(){

        String sql = "SELECT * FROM rebeldes";

        try{
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){

                Long idRebelde = resultSet.getLong("id_rebelde");
                String nomeRebelde = resultSet.getString("nome");
                int idadeRebelde = resultSet.getInt("idade");
                String generoRebelde = resultSet.getString("genero");
                String localizacaoRebelde = resultSet.getString("localizacao");
                boolean rebeldeAtivo = resultSet.getBoolean("reb_ativo");
                boolean rebeldeTraidor = resultSet.getBoolean("traidor");

                RebeldeModel rebelde = new RebeldeModel(idRebelde, nomeRebelde, idadeRebelde, generoRebelde, localizacaoRebelde,
                        rebeldeAtivo, rebeldeTraidor);

                System.out.printf("ID: %d | Nome: %s | Idade: %d | Genero: %s | Localização: %s | Ativo: %b | Traidor: %b",
                        idRebelde, nomeRebelde, idadeRebelde, generoRebelde, localizacaoRebelde, rebeldeAtivo, rebeldeTraidor);
                rebeldes.add(rebelde);
            }

            return rebeldes;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    //Atualiza a localização de um rebelde já existente na base de dados
    public void atualizaLocalizacao(Long id, String localizacao){
        String sql = String.format("UPDATE rebeldes SET localizacao = '%s' WHERE id_rebelde = '%d'", localizacao, id);

        try{

            statement.executeUpdate(sql);
            System.out.println("Localização do rebelde: " + id + " atualizado com sucesso!");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Reporta rebelde como traidor
    public void reportaRebelde(Long id_denuciante, Long id_reportado){
        String sql = String.format("INSERT INTO reportes (id_denunciante, id_reportado) VALUES (%d, %d)" , id_denuciante, id_reportado);

        try{
            statement.executeUpdate(sql);
            System.out.println("Rebelde: " + id_reportado + " foi reportado com sucesso!");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //Verifica a quantidade de reportes para um rebelde virar traidor
    public boolean verificaRebeldeTraidor(Long id_rebelde){
        String sql = String.format("SELECT id_reportado, COUNT(*) AS qtd_reportes FROM reportes WHERE id_reportado = '%d' GROUP BY id_reportado", id_rebelde);

        try{
            ResultSet resultSet = statement.executeQuery(sql);
            int qtdReports = 0;

            while(resultSet.next()){
                qtdReports = resultSet.getInt("qtd_reportes");
            }

            return qtdReports >= 3;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    //Altera o status após um rebelde ser reportado 3x
    public boolean alteraStatusTraidor(Long id_rebelde){
        if(verificaRebeldeTraidor(id_rebelde)){

            String sql = String.format("UPDATE rebeldes SET traidor = 'true', ativo = 'false' WHERE id_rebelde = '%d'", id_rebelde);
            try{
                statement.executeUpdate(sql);
                System.out.println("Rebelde: " + id_rebelde + "atualizado como traidor!");
                return true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }


}
