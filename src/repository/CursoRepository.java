package repository;

import model.Curso;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();

    public void salvar(Curso curso) {
        cursos.add(curso);
    }

    public List<Curso> listarTodos() {
        return new ArrayList<>(cursos);
    }
}