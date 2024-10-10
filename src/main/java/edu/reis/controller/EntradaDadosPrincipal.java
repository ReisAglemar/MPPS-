package edu.reis.controller;

import edu.reis.model.Crud;
import edu.reis.view.SaidaDados;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class EntradaDadosPrincipal {
    public static void entradaDadosPrincipal() {

        Scanner teclado = new Scanner(System.in);
        SaidaDados saidaDados = new SaidaDados();
        ValidaDadosEntrada validaDadosEntrada = new ValidaDadosEntrada(saidaDados);
        Crud crud = new Crud(saidaDados);
        EntradaDadosAuxiliar entradaDadosAuxiliar =
                new EntradaDadosAuxiliar(teclado, saidaDados, validaDadosEntrada, crud);


        saidaDados.logo();
        int opcao = 1137;

        do {
            try {
                saidaDados.menu();
                opcao = teclado.nextInt();
                teclado.nextLine();

                switch (opcao) {

                    case 1:
                        entradaDadosAuxiliar.requisitaAdicionarCliente();
                        break;

                    case 2:
                        entradaDadosAuxiliar.requisitaListarClientes();
                        break;

                    // Atualiza, Remove, Busca
                    case 3, 4, 5:
                        saidaDados.solicitaId();
                        entradaDadosAuxiliar.requisitaTestarEntrada(opcao);
                        break;

                    case 6:
                        entradaDadosAuxiliar.requisitaListarClientesRemovidos();
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
