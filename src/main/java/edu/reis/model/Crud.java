package edu.reis.model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Crud implements Icrud {

    private final List<Cliente> clientes = new ArrayList<>();


    @Override
    public void adicionaCliente(Cliente cliente) {

        try {
            this.clientes.add(cliente);
            System.out.println("Cliente adicionado com sucesso!");

        } catch (NullPointerException | UnsupportedOperationException e) {
            System.out.println("Erro ao adicionar cliente. Verifique a lista de clientes!");

        } catch (OutOfMemoryError e) {
            System.out.println("Erro ao adicionar cliente. Verifique a disponibilidade de memória!");

        } catch (Exception e) {
            System.out.println("Erro inesperado. Informe essa mensagem ao suporte: " + e.getMessage());
        }
    }


    @Override
    public void removeCliente(int id) {

        Cliente cliente = buscaClientePorId(id);

        if (cliente != null) {
            this.clientes.remove(cliente);
            System.out.println("Cliente com ID- " + id + " removido com sucesso!");

        } else {
            clienteNaoEncontrado(id);
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
                    mostraOpcoes();

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
                            System.out.println("Opção inválida!");
                    }

                } catch (InputMismatchException e) {
                    teclado.nextLine();
                    System.out.println("Verifique o tipo de dado informado.");

                } catch (IllegalArgumentException e){
                    System.out.println("Erro ao atualizar de cliente: " + e.getMessage());
                }

            } while (opcao != 0);

        } else {
            clienteNaoEncontrado(id);
        }
    }


    @Override
    public void listaClientes() {

        if(clientes.isEmpty()) {
            System.out.println("A lista de clientes está vazia!");
            return;
        }

        for (Cliente cliente : clientes) {
            mostraCliente(cliente);
        }

    }


    @Override
    public void buscarClientePorId(int id) {

        Cliente cliente = buscaClientePorId(id);

        if (cliente != null) {
            mostraCliente(cliente);

        } else {
            clienteNaoEncontrado(id);
        }

    }


    // FUNÇÕES AUXILIARES;

    private Cliente buscaClientePorId(int id) {

        for (Cliente cliente : clientes) {

            if (cliente.getId() == id) {
                return cliente;
            }
        }

        return null;
    }


    private void mostraCliente(Cliente cliente) {

        String mostraCliente = """
                
                ============= Cliente =============
                ID: %d
                Nome: %s
                E-mail: %s
                Telefone: %s
                """.formatted(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());

        System.out.println(mostraCliente);
    }


    private void clienteNaoEncontrado(int id) {

        System.out.println("Cliente com ID- " + id + " não foi encontrado!");
        System.out.println("Verifique o ID informado.");

    }


    private void mostraOpcoes() {

        String mostraOpcoes = """
                
                    Escolha qual dado deseja modificar
                
                    1- Para alterar o nome do cliente;
                    2- Para alterar o e-mail do cliente;
                    3- Para alterar o telefone do cliente;
                    0- Para finalizar as alterações;
                
                """;

        System.out.println(mostraOpcoes);
    }
}
