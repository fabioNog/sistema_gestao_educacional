package model;

public abstract class Curso {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    // Agora abstrato para forçar override
    public abstract String detalharCurso();

    public abstract String gerarRelatorio();

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "model.Curso: " + nome + ", Código: " + codigo + ", Carga Horária: " + cargaHoraria + " horas";
    }

}