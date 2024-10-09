package edu.reis.model;

import edu.reis.view.SaidaTela;

import java.util.ArrayList;
import java.util.List;

public class Crud implements Icrud {

    private final SaidaTela saidaTela;
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Cliente> clientesRemovidos = new ArrayList<>();


    public Crud(SaidaTela saidaTela) {
        this.saidaTela = saidaTela;
    }


    @Override
    public void adicionaCliente(Cliente cliente) {

        try {
            this.clientes.add(cliente);
            saidaTela.clienteAdicionado();

        } catch (OutOfMemoryError e) {
            saidaTela.outOfMemoryError();

        } catch (Exception e) {
            saidaTela.exceptionEspecial(e);
        }
    }


    @Override
    public void removeCliente(int id) {

        Cliente cliente = buscaClientePorId(id);

        if (cliente != null) {
            this.clientesRemovidos.add(cliente);
            this.clientes.remove(cliente);
            saidaTela.clienteRemovido(id);

        } else {
            saidaTela.clienteNaoEncontrado(id);
        }
    }


    @Override
    public Cliente alterarCliente(int id) {

        Cliente cliente = buscaClientePorId(id);

        if (cliente != null) {
            return cliente;
        }

        saidaTela.clienteNaoEncontrado(id);
        return null;
    }


    @Override
    public void listaClientes() {

        if (clientes.isEmpty()) {
            saidaTela.listaVazia();
            return;
        }

        for (Cliente cliente : clientes) {
            saidaTela.mostraCliente(cliente);
        }
    }


    @Override
    public void listarClientesRemovidos() {

        if (clientesRemovidos.isEmpty()) {
            saidaTela.listaVazia();
            return;
        }

        for (Cliente clienteRemovido : clientesRemovidos) {
            saidaTela.mostraCliente(clienteRemovido);
        }
    }


    @Override
    public void buscarClientePorId(int id) {

        Cliente cliente = buscaClientePorId(id);

        if (cliente != null) {
            saidaTela.mostraCliente(cliente);

        } else {
            saidaTela.clienteNaoEncontrado(id);
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
