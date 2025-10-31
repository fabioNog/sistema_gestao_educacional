public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Fabio Nogueira do Carmo", "25132907-5", "Análise e Desenvolvimento de Sistemas");
        Avaliacao av1 = new Avaliacao("Prova 1");
        av1.atribuirNota(8.5);
        av1.atribuirNota(11); // Inválido
        aluno.adicionarAvaliacao(av1);

        System.out.println("Avaliação: " + av1.getDescricao() + ", Nota: " + av1.getNota());

        Curso presencial = new CursoPresencial("OO Presencial", "OOP101", 60, "Sala 101");
        Curso ead = new CursoEAD("OO EAD", "OOE101", 40, "Zoom");

        System.out.println(presencial.detalharCurso());
        System.out.println(ead.detalharCurso());
    }
}