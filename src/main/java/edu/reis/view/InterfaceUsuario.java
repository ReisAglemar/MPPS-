package edu.reis.view;

import edu.reis.model.Cliente;
import edu.reis.model.Crud;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {

    public static void interfacePrincipal() {

        Scanner teclado = new Scanner(System.in);
        Crud crud = new Crud();
        Apresentacao apresentacao = new Apresentacao();

        apresentacao.verLogo();

        int opcao = 1137;

        do {
            try {
                apresentacao.verMenu();
                opcao = teclado.nextInt();
                teclado.nextLine();

                switch (opcao) {

                    case 1:
                        break;

                    case 2:
                        break;

                    case 3:
                        break;

                    case 4:
                        break;

                    case 5:
                        break;

                    case 0:
                        apresentacao.verLogo();
                        apresentacao.verDespedida();
                        break;

                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }

            } catch (InputMismatchException e) {
                teclado.nextLine();
                System.out.println("Você deve inserir um número, dentro do intervalo do menu.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro durante a operção.");
                System.out.println("Detalhe: " + e.getMessage() + "\n");
            }
        } while (opcao != 0);


        teclado.close();
    }
}
