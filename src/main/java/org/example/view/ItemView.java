package org.example.view;


import org.example.controller.ItemController;
import org.example.model.ItemModel;
import org.example.service.ItemService;

import java.math.BigDecimal;
import java.util.Scanner;

import static org.example.view.MenuPrincipal.limparConsole;
import static org.example.view.MenuPrincipal.selecionarOpcao;

public class ItemView {

    private Scanner sc;
    private ItemService itemService;
    private ItemController itemController;


    public ItemView(){
        sc = new Scanner(System.in);
        itemService = new ItemService();
        itemController = new ItemController(itemService);
    }

    public void menuItem(){

        int opcao;

        do {

            System.out.println("MENU LOJA");
            System.out.println("Escolha uma das seguintes opções");
            System.out.println("1 - Adicionar um novo item a loja");
            System.out.println("2 - Consultar todos os itens");
            System.out.println("3 - Consultar item por ID");
            System.out.println("0 - Retornar ao MENU PRINCIPAL");
            opcao = selecionarOpcao();
            limparConsole();

            switch (opcao){
                case 1:
                    imprimirCadastroItem();
                    System.out.println("Digite ENTRE para voltar ao MENU");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 2:
                    itemController.buscaTodosItens();
                    System.out.println("Digite ENTRE para voltar ao MENU");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 3:
                    imprimirItemEspecifico();
                    System.out.println("Digite ENTRE para voltar ao MENU");
                    sc.nextLine();
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente escolhe de 1 - 3");
                    limparConsole();
                    break;
            }

        }while(opcao != 0);

    }

    public void imprimirCadastroItem(){
        System.out.println("Digite o nome do item: ");
        String nome = sc.nextLine();

        System.out.println("Digite o valor do seu item: ");
        BigDecimal valor = sc.nextBigDecimal();
        sc.nextLine();

        ItemModel novoItem = new ItemModel(nome, valor);
        itemController.adicionaItem(novoItem);
    }

    public void imprimirItemEspecifico(){
        System.out.println("Digite o id do item: ");
        Long id = sc.nextLong();
        sc.nextLine();
        itemController.buscaItemPorId(id);
    }

}
