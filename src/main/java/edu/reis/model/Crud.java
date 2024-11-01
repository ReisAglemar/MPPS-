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

        List<Cliente> clientesAtivos = new ArrayList<>();

        for (Cliente cliente : clientes) {
            if (cliente.getAtivo()) {
                clientesAtivos.add(cliente);
            }
        }

        if (!clientesAtivos.isEmpty()) {
            for (Cliente clienteAtivos : clientesAtivos) {
                saidaDados.mostraCliente(clienteAtivos);
            }
            return;
        }
        saidaDados.listaVazia();
    }


    @Override
    public void listaClientesDesativos() {

        List<Cliente> clientesDesativos = new ArrayList<>();

        for (Cliente cliente : clientes) {
            if (!cliente.getAtivo()) {
                clientesDesativos.add(cliente);
            }
        }

        if (!clientesDesativos.isEmpty()) {
            for (Cliente clienteDesativos : clientesDesativos) {
                saidaDados.mostraCliente(clienteDesativos);
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
