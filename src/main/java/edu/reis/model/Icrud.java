package edu.reis.model;

public interface Icrud {

    void adicionaCliente(Cliente cliente);

    void removeCliente(int id);

    Cliente alterarCliente(int id);

    void listaClientesAtivos();

    void listaClientesDesativos();

    void buscarClientePorId(int id);
}
