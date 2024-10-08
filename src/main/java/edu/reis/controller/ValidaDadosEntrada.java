package edu.reis.controller;

import edu.reis.view.SaidaTela;

public class ValidaDadosEntrada {


    public Integer validaEntrada(String entrada, SaidaTela saidaTela) {

        if (entrada.equalsIgnoreCase("sair")) {
            return null;
        }

        try {
            Integer id = Integer.parseInt(entrada);
            return id;

        } catch (NumberFormatException e) {
            saidaTela.numberFormatException();
        }
        return -1;
    }
}
