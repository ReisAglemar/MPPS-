package edu.reis.controller;

import edu.reis.model.Crud;
import edu.reis.model.Icrud;
import edu.reis.view.SaidaDados;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class EntradaDados {
    public static void entradaDados() {

        Scanner teclado = new Scanner(System.in);
        SaidaDados saidaDados = new SaidaDados();
        ValidaDadosEntrada validaDadosEntrada = new ValidaDadosEntrada(saidaDados);
        Icrud crud = new Crud(saidaDados);
        GerenciaOperacoes gerenciaOperacoes =
                new GerenciaOperacoes(teclado, saidaDados, validaDadosEntrada, crud);


        saidaDados.logo();
        int opcao = 1137;

        do {
            try {
                saidaDados.menu();
                opcao = teclado.nextInt();
                teclado.nextLine();

                switch (opcao) {

                    case 1:
                        gerenciaOperacoes.requisitaAdicionarCliente();
                        break;

                    case 2:
                        gerenciaOperacoes.requisitaListaClientesAtivos();
                        break;

                    // Atualiza, Remove, Busca
                    case 3, 4, 5:
                        saidaDados.solicitaId();
                        gerenciaOperacoes.requisitaTestarEntrada(opcao);
                        break;

                    case 6:
                        gerenciaOperacoes.requisitaListaClientesDesativos();
                        break;

                    case 0:
                        saidaDados.despedida();
                        break;

                    default:
                        saidaDados.opcaoInvalida();
                        break;
                }

            } catch (InputMismatchException e) {
                teclado.nextLine();
                saidaDados.inputMismatchException();

            } catch (IllegalArgumentException e) {
                saidaDados.illegalArgumentException(e);
            }

        } while (opcao != 0);

        teclado.close();
    }
}
