package org.example.view;

import org.example.controller.InventarioController;
import org.example.service.InventarioService;

import java.util.Scanner;

import static org.example.view.MenuPrincipal.limparConsole;
import static org.example.view.MenuPrincipal.selecionarOpcao;

public class InventarioView {

    private Scanner sc = new Scanner(System.in);
    private InventarioService inventarioService = new InventarioService();
    private InventarioController inventarioController = new InventarioController(inventarioService);


    public void menuInventario(){

        int opcao;

        do {

            System.out.println("MENU INVENTÁRIO");
            System.out.println("Escolha uma das seguintes opções");
            System.out.println("1 - Visualizar o inventário de um rebelde");
            System.out.println("2 - Comprar um item para um rebelde");
            System.out.println("0 - Retornar ao MENU PRINCIPAL");
            opcao = selecionarOpcao();
            limparConsole();

            switch (opcao){
                case 1:
                    imprimirInventario();
                    System.out.println("Digite ENTRE para voltar ao MENU");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 2:
                    imprimirComprarItem();
                    System.out.println("Digite ENTRE para voltar ao MENU");
                    sc.nextLine();
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente escolhe de 1 - 2");
                    limparConsole();
                    break;
            }

        }while(opcao != 0);

    }


    public void imprimirInventario(){
        System.out.println("Digite o ID do rebelde: ");
        Long idRebelde = sc.nextLong();
        sc.nextLine();

        System.out.println("---INVENTÁRIO---");
        inventarioController.visualizaInventario(idRebelde);
    }

    public void imprimirComprarItem(){

        System.out.println("Digite o id do rebelde: ");
        Long idRebelde = sc.nextLong();
        sc.nextLine();
        System.out.println("Digite o id do item: ");
        Long idItem = sc.nextLong();
        sc.nextLine();

        inventarioController.adicionarItemNoInventario(idRebelde, idItem);


    }




}
