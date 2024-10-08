package edu.reis.view;

import edu.reis.model.Cliente;

public class SaidaTela {


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


    public void listaVazia(){
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
                
                """.formatted(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
        System.out.println(mostraCliente);
    }


    public void clienteNaoEncontrado(int id) {
        String clieteNaoEncontrardo = """
                
                    Cliente Não Localizado.
                    ID Informado: %d
                
                """.formatted(id);
        System.out.println(clieteNaoEncontrardo);
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


    public void illegalArgumentException(Exception e) {
        String illegalArgumentException = """
                
                    Erro Durante a Operação!
                
                    Detalhe: %s
                
                """.formatted(e.getMessage());
        System.out.println(illegalArgumentException);
    }


    public void inputMismatchException(){
        String inputMismatchException = """
                
                    Verifique o Tipo de Dado,
                    Esperava-se Um Número.
                
                """;
        System.out.println(inputMismatchException);
    }


    public void numberFormatException(){
        String numberFormatException = """
                
                    O ID do Cliente Deve Ser um Número.
                    Tente novamente ou digite 'sair' para retornar ao menu.
                
                """;
        System.out.println(numberFormatException);
    }


    public void outOfMemoryError(){
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


    public void opcaoInvalida(){
        String opcaoInvalida = """
                
                    Você Escolheu Uma Opção Invalida!
                    Tente Novamente.
                
                """;
        System.out.println(opcaoInvalida);
    }


    public void precisaId() {
        String precisaId = """
                
                    Para realizar essa operação é necessário
                    informar o ID do cliente.
                
                """;
        System.out.println(precisaId);
    }


    public void despedida() {
        logo();
        String despedida = """
                
                    Obrigado Por Usar os Nossos Serviços.
                
                    Até breve!
                
                """;
        System.out.println(despedida);
    }


    public void logo() {
        String logo = """
                
                      ____   ____    _   _   ____ \s
                     / ___| |  _ \\  | | | | |  _ \\\s
                    | |     | |_) | | | | | | | | |
                    | |___  |  _ <  | |_| | | |_| |
                     \\____| |_| \\_\\  \\___/  |____/\s
                                              \s
                     Create | Read | Update | Delete
                _________________________________________
                
                
                """;
        System.out.println(logo);
    }


    public void menu() {
        String menu = """
                
                        Escolha uma opção:
                
                    1- Para Cadastrar um Novo Cliente (Create)
                
                    2- Para Listar os Clientes (Read)
                
                    3- Para Atualizar os Dados do Cliente (Update)
                
                    4- Para Remover um Cliente (Delete)
                
                    5- Busca um Cliente (Search)
                
                    0- Sair
                
                """;
        System.out.println(menu);
    }


    public void operacaoCancelada(){
        String operacaoCancelada = """
                
                    Operação Cancelada Pelo Cliente.
                
                """;
        System.out.println(operacaoCancelada);
    }
}
