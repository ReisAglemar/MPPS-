package edu.reis.controller;

import edu.reis.model.Cliente;
import edu.reis.model.Crud;
import edu.reis.view.SaidaTela;

import java.util.Scanner;

public class RealizaOperacoes {

    private final ValidaDadosEntrada validaDadosEntrada;
    private final SaidaTela saidaTela;
    private final Crud crud;
    private final Scanner teclado;


    public RealizaOperacoes(Scanner teclado,
                            SaidaTela saidaTela,
                            ValidaDadosEntrada validaDadosEntrada,
                            Crud crud) {
        this.teclado = teclado;
        this.saidaTela = saidaTela;
        this.validaDadosEntrada = validaDadosEntrada;
        this.crud = crud;
    }


    public void adicionarCliente(Scanner teclado) {

        saidaTela.solicitaNome();
        String nome = teclado.nextLine();

        saidaTela.solicitaEmail();
        String email = teclado.nextLine();

        saidaTela.solicitaTelefone();
        String telefone = teclado.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone);
        crud.adicionaCliente(cliente);
    }


    public void realizar(int opcao) {

        while (true) {

            String temporaria = teclado.nextLine();
            Integer id = validaDadosEntrada.validaEntrada(temporaria);

            if (id == null) {
                saidaTela.operacaoCancelada();
                return;
            }

            // 3. Atualização de Dados de Clientes (Update):
            if (id != -1 && opcao == 3) {

                Cliente clienteParaAlterar = crud.alterarCliente(id);
                Integer opcaoAtualizar;
                String novoDado;
                boolean dadosAtualizado = false;

                do {
                    saidaTela.menuAtualizarCliente();
                    String temporariaAtualizar = teclado.nextLine();
                    opcaoAtualizar = validaDadosEntrada.validaEntrada(temporariaAtualizar);

                    if (opcaoAtualizar == null) {
                        saidaTela.operacaoCancelada();
                        return;
                    }

                    try {
                        switch (opcaoAtualizar) {

                            case 1:
                                saidaTela.solicitaNome();
                                novoDado = teclado.nextLine();
                                clienteParaAlterar.setNome(novoDado);
                                dadosAtualizado = true;
                                break;

                            case 2:
                                saidaTela.solicitaEmail();
                                novoDado = teclado.nextLine();
                                clienteParaAlterar.setEmail(novoDado);
                                dadosAtualizado = true;
                                break;

                            case 3:
                                saidaTela.solicitaTelefone();
                                novoDado = teclado.nextLine();
                                clienteParaAlterar.setTelefone(novoDado);
                                dadosAtualizado = true;
                                break;

                            case 0:

                                if (dadosAtualizado){
                                    saidaTela.clienteAlterado();
                                } else {
                                    saidaTela.operacaoCancelada();
                                }

                                break;

                            default:
                                saidaTela.opcaoInvalida();
                                break;
                        }

                    } catch (IllegalArgumentException e) {
                        saidaTela.illegalArgumentException(e);
                    }

                } while (opcaoAtualizar != 0);
                return;
            }

            // 4. Remoção de Clientes (Delete):
            if (id != -1 && opcao == 4) {
                crud.removeCliente(id);
                return;
            }

            //5. Busca de Clientes:
            if (id != -1 && opcao == 5) {
                crud.buscarClientePorId(id);
                return;
            }
        }
    }

    public void listarClientes() {
        crud.listaClientes();
    }


    public void listarClientesRemovidos() {
        crud.listarClientesRemovidos();
    }
}
