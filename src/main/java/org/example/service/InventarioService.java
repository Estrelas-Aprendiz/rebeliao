package org.example.service;

import org.example.model.InvertarioModel;
import org.example.model.ItemModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.connection.Conexao.getConnection;

public class InventarioService {

    private Statement statement;
    private InvertarioModel invertarioModel;

    private RebeldeService rebeldeService;


    public InventarioService(){
        try{
            statement = getConnection().createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Visualiza o inventário de um rebelde específico
    public void visualizaInventario(Long id_rebelde){

        String sql = String.format("SELECT rebeldes.id_rebelde, base_compras.nome\n" +
                "FROM rebeldes\n" +
                "INNER JOIN inventario_rebeldes\n" +
                "ON rebeldes.id_rebelde = inventario_rebeldes.rebelde_id\n" +
                "INNER JOIN base_compras\n" +
                "ON inventario_rebeldes.item_id = base_compras.id_item\n" +
                "WHERE rebeldes.id_rebelde = %d", id_rebelde);

        try{

            ResultSet resultSet = statement.executeQuery(sql);
            int i = 1;

            while(resultSet.next()){

                String item = resultSet.getString("nome");
                System.out.printf("Item %d: %s | %n", i, item);
                i++;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public void adicionarItemNoInventario(Long id_rebelde, Long id_item){

        if (!rebeldeService.alteraStatusTraidor(id_rebelde)){
            String sql = String.format("INSERT INTO inventario_rebelde (rebelde_id, item_id)" +
                    "VALUES ('%d', '%d')", id_rebelde, id_item);

            try{

                statement.executeUpdate(sql);
                System.out.println("Item " + id_item + " comprado pelo rebelde: " + id_rebelde + " com sucesso!");

            }catch (SQLException e){
                e.printStackTrace();
            }
        }else {
            System.out.println("Não é possível realizar compras sendo um traidor!");
        }


    }

}
