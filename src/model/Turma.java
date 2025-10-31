package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos = new ArrayList<>();

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
    }

    public void adicionarAluno(Aluno aluno) { listaAlunos.add(aluno); }
    public void removerAluno(Aluno aluno) { listaAlunos.remove(aluno); }

    public String getCodigo() { return codigo; }
    public Professor getProfessor() { return professor; }
    public Curso getCurso() { return curso; }
    public List<Aluno> getListaAlunos() { return listaAlunos; }

    public String getResumo() {
        return "Turma: " + codigo +
                "\nProfessor: " + professor.getNome() +
                "\nCurso: " + curso.getNome() +
                "\nAlunos: " + listaAlunos.size();
    }
}