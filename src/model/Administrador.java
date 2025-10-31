package model;

public class Administrador extends Usuario implements Autenticacao {
    public Administrador(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return verificarSenha(login, senha);
    }
}