package edu.reis.controller;


import edu.reis.model.Crud;
import edu.reis.view.SaidaTela;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {

    public static void interfacePrincipal() {

        Scanner teclado = new Scanner(System.in);
        SaidaTela saidaTela = new SaidaTela();
        ValidaDadosEntrada validaDadosEntrada = new ValidaDadosEntrada();
        Crud crud = new Crud(saidaTela);
        RequesitaOperacoes requesitaOperacoes = new RequesitaOperacoes(validaDadosEntrada);



        saidaTela.logo();

        int opcao = 1137;

        do {

            try {
                saidaTela.menu();
                opcao = teclado.nextInt();
                teclado.nextLine();

                switch (opcao) {

                    case 1:
                        System.out.println("falta fazer");
                        break;

                    case 2:
                        crud.listaClientes();
                        break;

                    case 3:
                        System.out.println("falta fazer");
                        break;

                    case 4, 5:
                        saidaTela.precisaId();
                        requesitaOperacoes.requisitar(teclado, crud, opcao, saidaTela);
                        break;

                    case 0:
                        saidaTela.despedida();
                        break;

                    default:
                        saidaTela.opcaoInvalida();
                        break;
                }

            } catch (InputMismatchException e) {
                teclado.nextLine();
                saidaTela.inputMismatchException();

            } catch (IllegalArgumentException e) {
                saidaTela.illegalArgumentException(e);
            }

        } while (opcao != 0);

        teclado.close();
    }
}
