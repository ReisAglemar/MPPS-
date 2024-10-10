package edu.reis.controller;

import edu.reis.view.SaidaDados;

public class ValidaDadosEntrada {

    private final SaidaDados saidaDados;

    public ValidaDadosEntrada(SaidaDados saidaDados) {
        this.saidaDados = saidaDados;
    }


    public Integer validaEntrada(String entrada) {

        if (entrada.equalsIgnoreCase("sair")) {
            return null;
        }

        try {
            Integer id = Integer.parseInt(entrada);
            return id;

        } catch (NumberFormatException e) {
            saidaDados.numberFormatException();
        }
        return -1;
    }
}
