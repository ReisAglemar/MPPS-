package edu.reis.view;

public class Apresentacao {

    private String logo;
    private String menu;
    private String despedida;

    public Apresentacao() {
        this.logo = setLogo();
        this.menu = setMenu();
        this.despedida = setDespedida();
    }


    public void verLogo() {
        System.out.println(logo);
    }


    private String setLogo() {
        return """
                
                      ____   ____    _   _   ____ \s
                     / ___| |  _ \\  | | | | |  _ \\\s
                    | |     | |_) | | | | | | | | |
                    | |___  |  _ <  | |_| | | |_| |
                     \\____| |_| \\_\\  \\___/  |____/\s
                                              \s
                     Create | Read | Update | Delete
                _________________________________________
                
                
                """;
    }


    public void verMenu() {
        System.out.println(menu);
    }


    private String setMenu() {
        return """
                        Escolha uma opção:
                
                    1- Para Cadastrar um Novo Cliente (Create)
                
                    2- Para Listar os Clientes (Read)
                
                    3- Para Atualizar os Dados do Cliente (Update)
                
                    4- Para Remover um Cliente (Delete)
                
                    5- Busca um Cliente (Search)
                
                    0- Sair
                
                """;
    }


    public void verDespedida() {
        System.out.println(despedida);
    }


    private String setDespedida() {
        return """
                
                    Obrigado por usar os nossos serviços.
                
                    Até breve!
                
                """;
    }
}
