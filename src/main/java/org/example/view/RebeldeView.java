package org.example.view;

import org.example.controller.RebeldeController;
import org.example.model.RebeldeModel;
import org.example.service.RebeldeService;

import java.util.Scanner;

import static org.example.view.MenuPrincipal.selecionarOpcao;
import static org.example.view.MenuPrincipal.limparConsole;

public class RebeldeView {

    private Scanner sc;
    private RebeldeService rebeldeService;
    private RebeldeController rebeldeController;


    public RebeldeView(){
        sc = new Scanner(System.in);
        rebeldeService = new RebeldeService();
        rebeldeController = new RebeldeController(rebeldeService);
    }

    public void menuRebelde(){

        int opcao;

        do {

            System.out.println("MENU REBELDE");
            System.out.println("1 - Cadastrar rebelde");
            System.out.println("2 - Consultar todos os rebeldes");
            System.out.println("3 - Atualizar localização do rebelde");
            System.out.println("4 - Reportar rebelde como traidor");
            System.out.println("0 - Retornar ao MENU PRINCIPAL");
            opcao = selecionarOpcao();
            limparConsole();


            switch (opcao){
                case 1:
                    imprimiCadastroRebelde();
                    System.out.println("Digite ENTRE para voltar ao MENU");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 2:
                    rebeldeController.buscaTodosRebeldes();
                    System.out.println("Digite ENTRE para voltar ao MENU");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 3:
                    imprimirAtualizacaoLocalizao();
                    System.out.println("Digite ENTRE para voltar ao MENU");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 4:
                    imprimirReportarRebelde();
                    System.out.println("Digite ENTRE para voltar ao MENU");
                    sc.nextLine();
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente escolhe de 1 - 4");
                    limparConsole();
                    break;
            }
        }while (opcao != 0);

    }


    public void imprimiCadastroRebelde(){
        System.out.println("Digite o nome do rebelde: ");
        String nome = sc.nextLine();

        System.out.println("Digite a idade do rebelde: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o genero do rebelde: ");
        String genero = sc.nextLine();

        System.out.println("Digite a localização do rebelde: ");
        String localizacao = sc.nextLine();

        RebeldeModel novoRebelde = new RebeldeModel(nome, idade, genero, localizacao);
        rebeldeController.adicionaRebelde(novoRebelde);
    }

    public void imprimirAtualizacaoLocalizao(){

        System.out.println("Digite o id do rebelde: ");
        Long idRebelde = sc.nextLong();
        sc.nextLine();

        System.out.println("Digite a nova localização do rebelde: ");
        String localizacao = sc.nextLine();

        rebeldeController.atualizaLocalizacao(idRebelde, localizacao);
    }


    public void imprimirReportarRebelde(){
        System.out.println("Digite o ID do rebelde denunciante: ");
        Long idDenunciante = sc.nextLong();

        System.out.println("Digite o ID do rebelde reportado: ");
        Long idReportado = sc.nextLong();

        rebeldeController.reportarRebelde(idDenunciante, idReportado);
        rebeldeController.alterarStatusRebelde(idReportado);
    }

}
