package edu.reis.model;

import java.util.Scanner;

public interface Icrud {

    public void adicionaCliente(Cliente cliente);

    public void removeCliente(int id);

    public void alterarCliente(int id, Scanner teclado);

    public void listaClientes();

    public void listarClientesRemovidos();

    public void buscarClientePorId(int id);


}
