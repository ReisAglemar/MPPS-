package edu.reis.controller;

import edu.reis.view.SaidaTela;

public class ValidaDadosEntrada {

    private final SaidaTela saidaTela;

    public ValidaDadosEntrada(SaidaTela saidaTela) {
        this.saidaTela = saidaTela;
    }


    public Integer validaEntrada(String entrada) {

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
