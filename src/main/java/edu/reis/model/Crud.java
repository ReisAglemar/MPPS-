package edu.reis.model;

import edu.reis.view.SaidaDados;

import java.util.ArrayList;
import java.util.List;

public class Crud implements Icrud {

    private final SaidaDados saidaDados;
    private final List<Cliente> clientes = new ArrayList<>();


    public Crud(SaidaDados saidaDados) {
        this.saidaDados = saidaDados;
    }


    @Override
    public void adicionaCliente(Cliente cliente) {

        try {
            this.clientes.add(cliente);
            saidaDados.clienteAdicionado();

        } catch (OutOfMemoryError e) {
            saidaDados.outOfMemoryError();

        } catch (Exception e) {
            saidaDados.exceptionEspecial(e);
        }
    }


    @Override
    public void removeCliente(int id) {

        Cliente cliente = buscaClientePorId(id);

        if (cliente != null) {

            cliente.setAtivo(false);
            saidaDados.clienteRemovido(id);

        } else {
            saidaDados.clienteNaoEncontrado(id);
        }
    }


    @Override
    public Cliente alterarCliente(int id) {

        Cliente cliente = buscaClientePorId(id);

        if (cliente != null) {
            return cliente;
        }

        saidaDados.clienteNaoEncontrado(id);
        return null;
    }


    @Override
    public void listaClientesAtivos() {

        if (!clientes.isEmpty()) {

            for (Cliente cliente : clientes) {
                if (cliente.getAtivo()) {
                    saidaDados.mostraCliente(cliente);
                }
            }
            return;
        }

        saidaDados.listaVazia();
    }


    @Override
    public void listaClientesDesativos() {

        if (!clientes.isEmpty()) {

            for (Cliente cliente : clientes) {
                if (!cliente.getAtivo()) {
                    saidaDados.mostraCliente(cliente);
                }
            }
            return;
        }

        saidaDados.listaVazia();
    }


    @Override
    public void buscarClientePorId(int id) {

        Cliente cliente = buscaClientePorId(id);

        if (cliente != null) {
            saidaDados.mostraCliente(cliente);

        } else {
            saidaDados.clienteNaoEncontrado(id);
        }
    }


    // FUNÇÃO AUXILIAR
    private Cliente buscaClientePorId(int id) {

        for (Cliente cliente : clientes) {

            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
