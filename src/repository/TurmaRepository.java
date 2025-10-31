package repository;

import model.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {
    private List<Turma> turmas = new ArrayList<>();

    public void salvar(Turma turma) {
        turmas.add(turma);
    }

    public List<Turma> listarTodos() {
        return new ArrayList<>(turmas);
    }
}