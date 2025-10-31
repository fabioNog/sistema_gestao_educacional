package model;

public class CursoPresencial extends Curso {
    private String sala;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String sala) {
        super(nome, codigo, cargaHoraria);
        this.sala = sala;
    }

    @Override
    public String detalharCurso() {
        return "model.Curso Presencial: " + getNome() + ", Código: " + getCodigo() +
                ", Carga: " + getCargaHoraria() + ", Sala: " + sala;
    }

    @Override
    public String gerarRelatorio() {
        return "Relatório model.Curso Presencial: " + getNome() + ", Sala: " + sala;
    }
}