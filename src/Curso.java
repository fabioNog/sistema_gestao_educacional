public abstract class Curso {
    private String nome;
    private String codigo;
    private int cargaHoraria;
    // Agora abstrato para forçar override
    public abstract String detalharCurso();

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
        return "Curso: " + nome + ", Código: " + codigo + ", Carga Horária: " + cargaHoraria + " horas";
    }

    // Subclasse CursoPresencial
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

    // Subclasse CursoEAD
    public class CursoEAD extends Curso {
        private String plataforma;

        public CursoEAD(String nome, String codigo, int cargaHoraria, String plataforma) {
            super(nome, codigo, cargaHoraria);
            this.plataforma = plataforma;
        }

        @Override
        public String detalharCurso() {
            return "Curso EAD: " + getNome() + ", Código: " + getCodigo() +
                    ", Carga: " + getCargaHoraria() + ", Plataforma: " + plataforma;
        }
    }
}