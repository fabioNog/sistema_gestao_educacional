package ui;

import model.*;
import repository.*;
import service.TurmaService;

import java.util.Scanner;

public class MenuUI {
    private Scanner scanner = new Scanner(System.in);
    private AlunoRepository alunoRepo = new AlunoRepository();
    private ProfessorRepository profRepo = new ProfessorRepository();
    private CursoRepository cursoRepo = new CursoRepository();
    private TurmaRepository turmaRepo = new TurmaRepository();
    private TurmaService turmaService = new TurmaService(turmaRepo, alunoRepo);

    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== Sistema de Gestão Educacional ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Curso");
            System.out.println("4. Criar Turma");
            System.out.println("5. Matricular Aluno em Turma");
            System.out.println("6. Registrar Avaliação");
            System.out.println("7. Gerar Relatórios");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            int op = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            if (op == 0) break;
            executarAcao(op);
        }
    }

    private void executarAcao(int op) {
        switch (op) {
            case 1 -> cadastrarAluno();
            case 2 -> cadastrarProfessor();
            case 3 -> cadastrarCurso();
            case 4 -> criarTurma();
            case 5 -> matricularAluno();
            case 6 -> registrarAvaliacao();
            case 7 -> gerarRelatorios();
            default -> System.out.println("Opção inválida.");
        }
    }

    private void cadastrarAluno() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Matrícula: "); String mat = scanner.nextLine();
        System.out.print("Curso: "); String curso = scanner.nextLine();
        System.out.print("Login: "); String login = scanner.nextLine();
        System.out.print("Senha: "); String senha = scanner.nextLine();

        Aluno aluno = new Aluno(nome, mat, curso, login, senha);
        alunoRepo.salvar(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private void cadastrarProfessor() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Especialidade: "); String esp = scanner.nextLine();
        System.out.print("Registro: "); String reg = scanner.nextLine();
        System.out.print("Login: "); String login = scanner.nextLine();
        System.out.print("Senha: "); String senha = scanner.nextLine();

        Professor prof = new Professor(nome, esp, reg, login, senha);
        profRepo.salvar(prof);
        System.out.println("Professor cadastrado!");
    }

    private void cadastrarCurso() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Código: "); String cod = scanner.nextLine();
        System.out.print("Carga Horária: "); int carga = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo (1=Presencial, 2=EAD): "); int tipo = scanner.nextInt();
        scanner.nextLine();

        Curso curso;
        if (tipo == 1) {
            System.out.print("Sala: "); String sala = scanner.nextLine();
            curso = new CursoPresencial(nome, cod, carga, sala);
        } else {
            System.out.print("Plataforma: "); String plat = scanner.nextLine();
            curso = new CursoEAD(nome, cod, carga, plat);
        }
        cursoRepo.salvar(curso);
        System.out.println("Curso cadastrado!");
    }

    private void criarTurma() {
        System.out.print("Código da Turma: "); String cod = scanner.nextLine();
        System.out.print("Registro do Professor: "); String reg = scanner.nextLine();
        System.out.print("Código do Curso: "); String codCurso = scanner.nextLine();

        Professor prof = profRepo.listarTodos().stream()
                .filter(p -> p.getRegistro().equals(reg))
                .findFirst().orElse(null);
        Curso curso = cursoRepo.listarTodos().stream()
                .filter(c -> c.getCodigo().equals(codCurso))
                .findFirst().orElse(null);

        if (prof != null && curso != null) {
            Turma turma = new Turma(cod, prof, curso);
            turmaRepo.salvar(turma);
            System.out.println("Turma criada!");
        } else {
            System.out.println("Professor ou curso não encontrado.");
        }
    }

    private void matricularAluno() {
        System.out.print("Código da Turma: "); String codTurma = scanner.nextLine();
        System.out.print("Matrícula do Aluno: "); String mat = scanner.nextLine();
        turmaService.matricularAluno(codTurma, mat);
    }

    private void registrarAvaliacao() {
        System.out.print("Matrícula do Aluno: "); String mat = scanner.nextLine();
        Aluno aluno = alunoRepo.buscarPorMatricula(mat);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        System.out.print("Descrição da Avaliação: "); String desc = scanner.nextLine();
        System.out.print("Nota (0-10): "); double nota = scanner.nextDouble();
        scanner.nextLine();

        Avaliacao av = new Avaliacao(desc);
        av.atribuirNota(nota);
        aluno.adicionarAvaliacao(av);
        System.out.println("Avaliação registrada!");
    }

    private void gerarRelatorios() {
        System.out.println("\n--- RELATÓRIOS ---");
        alunoRepo.listarTodos().forEach(a -> System.out.println(a.gerarRelatorio()));
        profRepo.listarTodos().forEach(p -> System.out.println(p.gerarRelatorio()));
        cursoRepo.listarTodos().forEach(c -> System.out.println(c.gerarRelatorio()));
        turmaRepo.listarTodos().forEach(t -> System.out.println(t.getResumo()));
    }
}