package edu.reis.controller;

import edu.reis.model.Crud;
import edu.reis.view.SaidaTela;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class InterfaceUsuario {

    public static void interfacePrincipal() {

        Scanner teclado = new Scanner(System.in);
        SaidaTela saidaTela = new SaidaTela();
        ValidaDadosEntrada validaDadosEntrada = new ValidaDadosEntrada(saidaTela);
        Crud crud = new Crud(saidaTela);
        RealizaOperacoes realizaOperacoes = new RealizaOperacoes(teclado, saidaTela, validaDadosEntrada, crud);


        saidaTela.logo();
        int opcao = 1137;

        do {
            try {
                saidaTela.menu();
                opcao = teclado.nextInt();
                teclado.nextLine();

                switch (opcao) {

                    case 1:
                        realizaOperacoes.adicionarCliente(teclado);
                        break;

                    case 2:
                        realizaOperacoes.listarClientes();
                        break;

                    // Atualiza, Remove, Busca
                    case 3, 4, 5:
                        saidaTela.solicitaId();
                        realizaOperacoes.realizar(opcao);
                        break;

                    case 6:
                        realizaOperacoes.listarClientesRemovidos();
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
