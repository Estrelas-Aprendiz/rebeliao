package org.example.view;

import org.example.controller.RelatorioController;
import org.example.service.RelatorioService;

import java.util.Scanner;

import static org.example.view.MenuPrincipal.selecionarOpcao;
import static org.example.view.MenuPrincipal.limparConsole;

public class RelatorioView {

    private Scanner sc;
    private RelatorioController relatorioController;
    private RelatorioService relatorioService;

    public RelatorioView(){
        sc = new Scanner(System.in);
        relatorioController = new RelatorioController(relatorioService);
        relatorioService = new RelatorioService();
    }

    public void menuRelarorio(){

        int opcao;

        do {

            System.out.println("MENU RELATÓRIO");
            System.out.println("1 - Visualizar relatório");
            System.out.println("0 - Retornar ao MENU PRINCIPAL");
            opcao = selecionarOpcao();
            limparConsole();

            switch (opcao){
                case 1:
                    imprimirRelatorio();
                    System.out.println("Digite ENTRE para voltar ao MENU");
                    sc.nextLine();
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    limparConsole();
                    break;
            }
        }while (opcao != 0);

    }

    public void imprimirRelatorio(){

        int qtdTraidores = relatorioController.geraQtdTraidores();
        int qtdRebeldes = relatorioController.geraQtdRebeldes();
        double porcentagemTraidores = relatorioController.geraPorcentagemTraidores();
        double porcentagemRebeldes = relatorioController.geraPorcentagemRebeldes();

        System.out.println("-------------------------------------------");
        System.out.println("------Relatório de Rebelde e Traidores------");
        System.out.println("-------------------------------------------");
        System.out.println("|             |Quantidade | Porcentagem   |");
        System.out.printf ("|Rebeldes     |    %d     | %.2f%%        | %n", qtdRebeldes, porcentagemRebeldes );
        System.out.printf ("|Traidores    |    %d     | %.2f%%        | %n", qtdTraidores, porcentagemTraidores );
        System.out.printf ("|             |           |               | %n");
        System.out.printf ("|TOTAL:       |    %d     | 100,00%       | %n", qtdRebeldes + qtdTraidores);
        System.out.println("-------------------------------------------");

    }

}
