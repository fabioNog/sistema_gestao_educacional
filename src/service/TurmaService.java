package service;

import model.Aluno;
import model.Turma;
import repository.AlunoRepository;
import repository.TurmaRepository;

public class TurmaService {
    private TurmaRepository turmaRepo;
    private AlunoRepository alunoRepo;

    public TurmaService(TurmaRepository turmaRepo, AlunoRepository alunoRepo) {
        this.turmaRepo = turmaRepo;
        this.alunoRepo = alunoRepo;
    }

    public void matricularAluno(String codigoTurma, String matriculaAluno) {
        Turma turma = turmaRepo.listarTodos().stream()
                .filter(t -> t.getCodigo().equals(codigoTurma))
                .findFirst().orElse(null);
        Aluno aluno = alunoRepo.buscarPorMatricula(matriculaAluno);

        if (turma != null && aluno != null) {
            turma.adicionarAluno(aluno);
            System.out.println("Aluno " + aluno.getNome() + " matriculado na turma " + codigoTurma);
        } else {
            System.out.println("Turma ou aluno não encontrado.");
        }
    }
}