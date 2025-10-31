public class CursoPresencial extends Curso {
    private String sala;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String sala) {
        super(nome, codigo, cargaHoraria);
        this.sala = sala;
    }

    @Override
    public String detalharCurso() {
        return "Curso Presencial: " + getNome() + ", Código: " + getCodigo() +
                ", Carga: " + getCargaHoraria() + ", Sala: " + sala;
    }
}