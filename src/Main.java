public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Fabio", "25132907-5", "ADS", "fabio", "123");
        System.out.println("Autenticação Aluno: " + aluno.autenticar("fabio", "123")); // true
        System.out.println("Autenticação Falha: " + aluno.autenticar("fabio", "errado"));
    }
}