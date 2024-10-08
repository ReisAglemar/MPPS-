package edu.reis.controller;

import edu.reis.model.Crud;
import edu.reis.view.SaidaTela;

import java.util.Scanner;

public class RequesitaOperacoes {

    private final ValidaDadosEntrada validaDadosEntrada;


    public RequesitaOperacoes(ValidaDadosEntrada validaDadosEntrada) {
        this.validaDadosEntrada = validaDadosEntrada;
    }


    public void requisitar(Scanner teclado, Crud crud, int opcao, SaidaTela saidaTela) {

        while (true) {
            String temporaria = teclado.nextLine();
            Integer id = validaDadosEntrada.validaEntrada(temporaria, saidaTela);

            if (id == null) {
                saidaTela.operacaoCancelada();
                return;
            }

            if (id != -1 && opcao == 5) {
                crud.buscarClientePorId(id);
                return;
            }

            if (id != -1 && opcao == 4) {
                crud.removeCliente(id);
                return;
            }
        }
    }
}
