package edu.reis.controller;

import edu.reis.model.Cliente;
import edu.reis.model.Icrud;
import edu.reis.view.SaidaDados;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciaOperacoes {

    private final ValidaDadosEntrada validaDadosEntrada;
    private final SaidaDados saidaDados;
    private final Icrud crud;
    private final Scanner teclado;


    public GerenciaOperacoes(Scanner teclado,
                             SaidaDados saidaDados,
                             ValidaDadosEntrada validaDadosEntrada,
                             Icrud crud) {
        this.teclado = teclado;
        this.saidaDados = saidaDados;
        this.validaDadosEntrada = validaDadosEntrada;
        this.crud = crud;
    }


    public void requisitaAdicionarCliente() {

        saidaDados.solicitaNome();
        String nome = teclado.nextLine();

        saidaDados.solicitaEmail();
        String email = teclado.nextLine();

        saidaDados.solicitaTelefone();
        String telefone = teclado.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone);
        crud.adicionaCliente(cliente);
    }


    public void requisitaTestarEntrada(int opcao) {

        while (true) {

            String temporaria = teclado.nextLine();
            Integer id = validaDadosEntrada.validaId(temporaria);

            if (id == null) {
                saidaDados.operacaoCancelada();
                return;
            }

            // 3. Atualização de Dados de Clientes (Update):
            if (id != -1 && opcao == 3) {
                requisitaAlterarCliente(id);
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


    public void requisitaListaClientesAtivos() {
        crud.listaClientesAtivos();
    }


    public void requisitaListaClientesDesativos() {
        crud.listaClientesDesativos();
    }


    // FUNÇÃO AUXILIAR
    private void requisitaAlterarCliente(Integer id) {

        Cliente clienteParaAlterar = crud.alterarCliente(id);

        if (clienteParaAlterar == null) {
            return;
        }

        // cria buffer para a atualização de cadastro
        Cliente clienteBuffer = new Cliente(clienteParaAlterar.getNome(),
                clienteParaAlterar.getEmail(), clienteParaAlterar.getTelefone(), true);

        Integer opcaoAtualizar;
        String novoDado;
        boolean dadosAtualizado = false;

        do {
            saidaDados.menuAtualizarCliente();
            String temporaria = teclado.nextLine();
            opcaoAtualizar = validaDadosEntrada.validaOpcaoMenu(temporaria);

            if (opcaoAtualizar == null) {
                saidaDados.operacaoCancelada();
                return;
            }

            try {
                switch (opcaoAtualizar) {

                    case 1:
                        saidaDados.solicitaNome();
                        novoDado = teclado.nextLine();
                        clienteBuffer.setNome(novoDado);
                        dadosAtualizado = true;
                        break;

                    case 2:
                        saidaDados.solicitaEmail();
                        novoDado = teclado.nextLine();
                        clienteBuffer.setEmail(novoDado);
                        dadosAtualizado = true;
                        break;

                    case 3:
                        saidaDados.solicitaTelefone();
                        novoDado = teclado.nextLine();
                        clienteBuffer.setTelefone(novoDado);
                        dadosAtualizado = true;
                        break;

                    case 0:

                        if (dadosAtualizado) {
                            saidaDados.mostraAlteracao(clienteParaAlterar, clienteBuffer);
                            saidaDados.perguntaSalvaAteracao();
                            temporaria = teclado.nextLine();
                            Integer opcaoSalvar = validaDadosEntrada.validaOpcaoMenu(temporaria);

                            switch (opcaoSalvar) {
                                case 1:
                                    clienteParaAlterar.setNome(clienteBuffer.getNome());
                                    clienteParaAlterar.setEmail(clienteBuffer.getEmail());
                                    clienteParaAlterar.setTelefone(clienteBuffer.getTelefone());
                                    saidaDados.atulizacaoSalva();
                                    break;

                                case 2:
                                    saidaDados.atulizacaoDescartada();
                                    break;
                                default:
                                    saidaDados.opcaoInvalida();
                                    break;
                            }

                        } else {
                            saidaDados.operacaoCancelada();
                        }
                        break;

                    default:
                        saidaDados.opcaoInvalida();
                        break;
                }

            } catch (InputMismatchException e) {
                saidaDados.inputMismatchException();
            }

        } while (opcaoAtualizar != 0);
    }
}
