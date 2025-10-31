package model;

public class Avaliacao {
    private double nota;
    private String descricao;

    public Avaliacao(String descricao) {
        this.descricao = descricao;
        this.nota = 0.0; // Nota inicial
    }

    public void atribuirNota(double valor) {
        if (valor >= 0 && valor <= 10) {
            this.nota = valor;
        } else {
            System.out.println("Nota inválida! Deve estar entre 0 e 10.");
        }
    }

    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }
}





