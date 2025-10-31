// Classe Turma
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        listaAlunos.remove(aluno);
    }

    public String getResumo() {
        return "Turma: " + codigo + "\nProfessor: " + professor.getNome() +
                "\nCurso: " + curso.getNome() +
                "\nAlunos matriculados: " + listaAlunos.size();
    }
}

