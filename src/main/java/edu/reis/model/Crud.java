package edu.reis.model;

import edu.reis.view.SaidaTela;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
    public void alterarCliente(int id, Scanner teclado) {

        Cliente cliente = buscaClientePorId(id);

        if (cliente != null) {

            int opcao = 1137;
            String novoDado;

            do {

                try {
                    saidaTela.menuAtualizarCliente();

                    opcao = teclado.nextInt();
                    teclado.nextLine();

                    switch (opcao) {

                        case 1:
                            System.out.print("Insira o nome do cliente: ");
                            novoDado = teclado.nextLine();
                            cliente.setNome(novoDado);
                            break;

                        case 2:
                            System.out.print("Insira o e-mail do cliente: ");
                            novoDado = teclado.nextLine();
                            cliente.setEmail(novoDado);
                            break;

                        case 3:
                            System.out.print("Insira o telefone do cliente: ");
                            novoDado = teclado.nextLine();
                            cliente.setTelefone(novoDado);
                            break;

                        case 0:
                            System.out.println("Operação finalizada com sucesso!");
                            break;

                        default:
                            saidaTela.opcaoInvalida();
                    }

                } catch (InputMismatchException e) {
                    teclado.nextLine();
                    saidaTela.inputMismatchException();

                } catch (IllegalArgumentException e) {
                    saidaTela.illegalArgumentException(e);
                }

            } while (opcao != 0);

        } else {
            saidaTela.clienteNaoEncontrado(id);
        }
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
