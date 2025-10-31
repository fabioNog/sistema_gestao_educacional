// Classe Main para testar
public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Fabio Nogueira do Carmo", "25132907-5", "Análise e Desenvolvimento de Sistemas");
        Professor professor = new Professor("Dr. João Silva", "Programação", "REG123");
        Curso curso = new Curso("Orientação a Objetos", "OO101", 60);

        System.out.println(aluno);
        System.out.println(professor);
        System.out.println(curso);
    }
}