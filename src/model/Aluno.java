package model;

import java.util.ArrayList;
import java.util.List;


public class Aluno extends Usuario implements Autenticacao {
    private String nome;
    private String matricula;
    private String curso;

    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Aluno(String nome, String matricula, String curso, String login, String senha) {
        super(nome, login, senha);
        this.matricula = matricula;
        this.curso = curso;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return verificarSenha(login, senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "model.Aluno: " + nome + ", Matrícula: " + matricula + ", model.Curso: " + curso;
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public String gerarRelatorio() {
        return "Relatório model.Aluno: " + getNome() + ", Matrícula: " + matricula + ", model.Curso: " + curso;
    }
}



