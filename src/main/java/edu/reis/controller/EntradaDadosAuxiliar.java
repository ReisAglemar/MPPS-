package edu.reis.controller;

import edu.reis.model.Cliente;
import edu.reis.model.Crud;
import edu.reis.view.SaidaDados;

import java.util.Scanner;

public class EntradaDadosAuxiliar {

    private final ValidaDadosEntrada validaDadosEntrada;
    private final SaidaDados saidaDados;
    private final Crud crud;
    private final Scanner teclado;


    public EntradaDadosAuxiliar(Scanner teclado,
                                SaidaDados saidaDados,
                                ValidaDadosEntrada validaDadosEntrada,
                                Crud crud) {
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
            Integer id = validaDadosEntrada.validaEntrada(temporaria);

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


    public void requisitaListarClientes() {
        crud.listaClientes();
    }


    public void requisitaListarClientesRemovidos() {
        crud.listarClientesRemovidos();
    }


    // FUNÇÃO AUXILIAR
    private void requisitaAlterarCliente(Integer id) {

        Cliente clienteParaAlterar = crud.alterarCliente(id);

        if (clienteParaAlterar == null) {
            return;
        }

        Integer opcaoAtualizar;
        String novoDado;
        boolean dadosAtualizado = false;

        do {
            saidaDados.menuAtualizarCliente();
            String temporariaAtualizar = teclado.nextLine();
            opcaoAtualizar = validaDadosEntrada.validaEntrada(temporariaAtualizar);

            if (opcaoAtualizar == null) {
                saidaDados.operacaoCancelada();
                return;
            }

            try {
                switch (opcaoAtualizar) {

                    case 1:
                        saidaDados.solicitaNome();
                        novoDado = teclado.nextLine();
                        clienteParaAlterar.setNome(novoDado);
                        dadosAtualizado = true;
                        break;

                    case 2:
                        saidaDados.solicitaEmail();
                        novoDado = teclado.nextLine();
                        clienteParaAlterar.setEmail(novoDado);
                        dadosAtualizado = true;
                        break;

                    case 3:
                        saidaDados.solicitaTelefone();
                        novoDado = teclado.nextLine();
                        clienteParaAlterar.setTelefone(novoDado);
                        dadosAtualizado = true;
                        break;

                    case 0:

                        if (dadosAtualizado) {
                            saidaDados.clienteAlterado();
                        } else {
                            saidaDados.operacaoCancelada();
                        }
                        break;

                    default:
                        saidaDados.opcaoInvalida();
                        break;
                }

            } catch (IllegalArgumentException e) {
                saidaDados.illegalArgumentException(e);
            }

        } while (opcaoAtualizar != 0);
    }
}
