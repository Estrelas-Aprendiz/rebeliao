package org.example.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner sc;
    private RebeldeView rebeldeView;
    private ItemView itemView;
    private InventarioView inventarioView;
    private RelatorioView relatorioView;


    public MenuPrincipal(){
        sc = new Scanner(System.in);
        rebeldeView = new RebeldeView();
        itemView = new ItemView();
        inventarioView = new InventarioView();
        relatorioView = new RelatorioView();
    }

    public void inciar(){

        int opcao;

        do{
            imprimiMenuPrincipal();
            opcao = selecionarOpcao();
            limparConsole();

            switch (opcao){
                case 1:
                    rebeldeView.menuRebelde();
                    break;
                case 2:
                    itemView.menuItem();
                    break;
                case 3:
                    inventarioView.menuInventario();
                    break;
                case 4:
                    relatorioView.menuRelarorio();
                    break;
            }
        }while(opcao != 0);

    }

    public void imprimiMenuPrincipal(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("Escolha uma das seguintes opções");
        System.out.println("1 - Acessar o menu do REBELDE");
        System.out.println("2 - Acessar o menu da LOJA");
        System.out.println("3 - Acessar o menu do INVENTÁRIO");
        System.out.println("4 - Acessar o menu do RELATÓRIO");

        System.out.println("Digite sua opção: ");
    }


    public static int selecionarOpcao(){

        Scanner sc = new Scanner(System.in);

        try{
            int opcao = sc.nextInt();
            sc.nextLine();
            return opcao;
        }catch (InputMismatchException e){
            e.printStackTrace();
            sc.nextLine();
            return 0;
        }
    }

    public static void limparConsole(){
        for (int i = 0; i < 20; i++ ){
            System.out.println();
        }
    }

}
