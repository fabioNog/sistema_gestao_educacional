package model;

public class CursoEAD extends Curso {
    private String plataforma;

    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataforma) {
        super(nome, codigo, cargaHoraria);
        this.plataforma = plataforma;
    }

    @Override
    public String detalharCurso() {
        return "model.Curso EAD: " + getNome() + ", Código: " + getCodigo() +
                ", Carga: " + getCargaHoraria() + ", Plataforma: " + plataforma;
    }

    @Override
    public String gerarRelatorio() {
        return "Relatório model.Curso EAD: " + getNome() + ", plataforma: " + plataforma;
    }
}