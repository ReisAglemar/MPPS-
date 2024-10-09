package edu.reis.model;

import java.util.Scanner;

public interface Icrud {

    void adicionaCliente(Cliente cliente);

    void removeCliente(int id);

    Cliente alterarCliente(int id);

    void listaClientes();

    void listarClientesRemovidos();

    void buscarClientePorId(int id);
}
