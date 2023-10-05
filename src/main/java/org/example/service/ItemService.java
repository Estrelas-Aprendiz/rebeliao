package org.example.service;

import org.example.model.ItemModel;
import org.example.model.RebeldeModel;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.connection.Conexao.getConnection;

public class ItemService {

    private Statement statement;
    private ItemModel itemModel;
    private List<ItemModel> itens;


    public ItemService(){
        itens = new ArrayList<>();

        try{
            statement = getConnection().createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Adiciona novo item na base de dados
    public void adicionaItem(ItemModel itemModel){
        String valor = String.valueOf(itemModel.getValor()).replace(",", ",");
        String sql = String.format("INSERT INTO base_compras (nome, valor) VALUES ('%s', '%s')", itemModel.getNome(), valor);


        try{
            statement.executeUpdate(sql);
            System.out.println("Item: " + itemModel.getNome() + " foi adicionado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Busca todos os itens existente dentro da base da dados
    public List<ItemModel> buscaTodosItens(){
        String sql = "SELECT * FROM base_compras";

        try{
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                Long idItem = resultSet.getLong("id_item");
                String nome = resultSet.getString("nome");
                BigDecimal valor = resultSet.getBigDecimal("valor");

                ItemModel item = new ItemModel(idItem, nome, valor);
                System.out.println("ID: " + idItem + " | Nome: " + nome + " | Valor: " + valor);

                itens.add(item);
            }
            return itens;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    //Busca um item específico pelo ID
    public ItemModel buscaItemPorId(Long id){
        String sql = String.format("SELECT * FROM base_compras WHERE id_item = '%d'", id);

        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Long idItem = resultSet.getLong("id_item");
                String nome = resultSet.getString("nome");
                BigDecimal valor = resultSet.getBigDecimal("valor");


                System.out.println("ID: " + idItem + " | Nome: " + nome + " | Valor: " + valor);
                ItemModel item = new ItemModel(idItem, nome, valor);
            }
            return itemModel;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
