package edu.reis.model;

public class Cliente {

    private static int idAuto = 1;

    private final int id;
    private String nome;
    private String email;
    private String telefone;
    private Boolean ativo;

    public Cliente(String nome, String email, String telefone) {

        if (nome == null || nome.trim().isEmpty() || nome.length() > 100 || nome.length() < 3) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou menor que 3 caracteres");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("e-mail não pode ser vazio");
        }

        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio");
        }

        this.id = idAuto++;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.ativo = true;
    }


    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }


    public String getTelefone() {
        return telefone;
    }


    public Boolean getAtivo() {
        return ativo;
    }


    public void setNome(String nome) {

        if (nome == null || nome.trim().isEmpty() || nome.length() > 100 || nome.length() < 3) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou menor que 3 caracteres");
        }

        this.nome = nome;
    }


    public void setEmail(String email) {

        if (email == null || email.trim().isEmpty() || email.length() > 100 || email.length() < 3) {
            throw new IllegalArgumentException("email não pode ser vazio ou menor que 3 caracteres");
        }

        this.email = email;
    }


    public void setTelefone(String telefone) {

        if (telefone == null || telefone.trim().isEmpty() || telefone.length() > 14 || telefone.length() < 8) {
            throw new IllegalArgumentException("Telefone não pode ser vazio ou maior que 14 caracteres ou menor que 8");
        }

        this.telefone = telefone;
    }


    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

