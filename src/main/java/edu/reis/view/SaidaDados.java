package edu.reis.view;

import edu.reis.model.Cliente;

public class SaidaDados {

    public SaidaDados() {

    }


    public void logo() {
        String logo = """
                
                       ____   ____    _   _   ____    _   _\s
                      / ___| |  _ \\  | | | | |  _ \\  | | | |
                     | |     | |_) | | | | | | | | | | |_| |
                     | |___  |  _ <  | |_| | | |_| | |  _  |
                      \\____| |_| \\_\\  \\___/  |____/  |_| |_|
                                                           \s
                                              \s
                     Create | Read | Update | Delete | History
                ____________________________________________________
                
                
                """;
        System.out.println(logo);
    }


    public void clienteAdicionado() {
        String clienteAdicionado = """
                
                    Cliente Adicionado Sucesso!
                
                """;
        System.out.println(clienteAdicionado);
    }


    public void clienteRemovido(int id) {
        String clienteRemovido = """
                
                    Cliente com ID %d
                    Removido Sucesso!
                
                """.formatted(id);
        System.out.println(clienteRemovido);
    }


    public void clienteAlterado() {
        String clienteAlterado = """
                
                    Cliente Alterado Sucesso!
                
                """;
        System.out.println(clienteAlterado);
    }


    public void listaVazia() {
        String listaVazia = """
                
                    A Lista de Clientes Está Vazia.
                
                """;
        System.out.println(listaVazia);
    }


    public void mostraCliente(Cliente cliente) {
        String mostraCliente = """
                
                ============= Cliente =============
                ID: %d
                Nome: %s
                E-mail: %s
                Telefone: %s
                Ativo: %s
                
                """.formatted(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getAtivo());
        System.out.println(mostraCliente);
    }


    public void clienteNaoEncontrado(int id) {
        String clieteNaoEncontrardo = """
                
                    Cliente Não Localizado.
                    ID Informado: %d
                
                """.formatted(id);
        System.out.println(clieteNaoEncontrardo);
    }


    public void solicitaNome() {
        String solicitaNome = """
                
                    Insira o Nome do Cliente.
                
                """;
        System.out.println(solicitaNome);
    }


    public void solicitaEmail() {
        String solicitaEmail = """
                
                    Insira o E-mail do Cliente.
                
                """;
        System.out.println(solicitaEmail);
    }


    public void solicitaTelefone() {
        String solicitaTefone = """
                
                    Insira o Telefone do Cliente.
                
                """;
        System.out.println(solicitaTefone);
    }


    public void solicitaId() {
        String precisaId = """
                
                    Para realizar essa operação é necessário
                    informar o ID do cliente.
                
                """;
        System.out.println(precisaId);
    }


    public void menu() {
        String menu = """
                
                        Escolha uma opção:
                
                    1- Para Cadastrar um Novo Cliente (Create)
                
                    2- Para Listar os Clientes (Read)
                
                    3- Para Atualizar os Dados do Cliente (Update)
                
                    4- Para Remover um Cliente (Delete)
                
                    5- Busca um Cliente (Search)
                
                    6- Para Listar os Ex-Clientes (History)
                
                    0- Sair
                
                """;
        System.out.println(menu);
    }


    public void menuAtualizarCliente() {
        String menuAtualizarCliente = """
                
                    Escolha qual dado deseja modificar
                
                    1- Para alterar o nome do cliente;
                    2- Para alterar o e-mail do cliente;
                    3- Para alterar o telefone do cliente;
                    0- Para finalizar as alterações;
                
                """;
        System.out.println(menuAtualizarCliente);
    }


    public void opcaoInvalida() {
        String opcaoInvalida = """
                
                    Você Escolheu Uma Opção Invalida!
                    Tente Novamente.
                
                """;
        System.out.println(opcaoInvalida);
    }


    public void despedida() {
        logo();
        String despedida = """
                
                    Obrigado Por Usar os Nossos Serviços.
                
                    Até breve!
                
                """;
        System.out.println(despedida);
    }


    public void operacaoCancelada() {
        String operacaoCancelada = """
                
                    Operação Cancelada Pelo Cliente.
                
                """;
        System.out.println(operacaoCancelada);
    }


    public void illegalArgumentException(Exception e) {
        String illegalArgumentException = """
                
                    Erro Durante a Operação!
                
                    Detalhe: %s
                
                """.formatted(e.getMessage());
        System.out.println(illegalArgumentException);
    }


    public void inputMismatchException() {
        String inputMismatchException = """
                
                    Verifique o Tipo de Dado,
                    Esperava-se Um Número.
                
                """;
        System.out.println(inputMismatchException);
    }


    public void numberFormatException() {
        String numberFormatException = """
                
                    O ID do Cliente Deve Ser um Número.
                    Tente novamente ou digite 'sair' para retornar ao menu.
                
                """;
        System.out.println(numberFormatException);
    }


    public void outOfMemoryError() {
        String outOfMemoryError = """
                
                    Erro ao adicionar cliente.
                    Verifique a disponibilidade de memória!
                
                """;
        System.out.println(outOfMemoryError);
    }


    public void exceptionEspecial(Exception e) {
        String exceptionEspecial = """
                
                    Erro Inesperado!
                    Contate o suporte!
                
                    Erro Detalhado: %s
                
                """.formatted(e.getMessage());
        System.out.println(exceptionEspecial);
    }
}
