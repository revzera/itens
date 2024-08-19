import java.util.ArrayList;

public class Ensalamento {
    ArrayList<Sala> salas;
    ArrayList<Turma> turmas;
    ArrayList<TurmaEmSala> ensalamento;

    public Ensalamento() {
        this.salas = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.ensalamento = new ArrayList<>();
    }

    public void addSala(Sala sala) {
        salas.add(sala);
    }

    public void addTurma(Turma turma) {
        turmas.add(turma);
    }

    public Sala getSala(Turma turma) {
        for (TurmaEmSala ts : ensalamento) {
            if (ts.turma.equals(turma)) {
                return ts.sala;
            }
        }
        return null;
    }

    public boolean salaDisponivel(Sala sala, int horario) {
        for (TurmaEmSala ts : ensalamento) {
            if (ts.sala.equals(sala)) {
                for (Integer h : ts.turma.horarios) {
                    if (h == horario) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios) {
        for (Integer horario : horarios) {
            if (!salaDisponivel(sala, horario)) {
                return false;
            }
        }
        return true;
    }

    public boolean alocar(Turma turma, Sala sala) {
        if (turma.acessivel == sala.acessivel && turma.numAlunos <= sala.capacidade && salaDisponivel(sala, turma.horarios)) {
            ensalamento.add(new TurmaEmSala(turma, sala));
            return true;
        }
        return false;
    }

    public void alocarTodas() {
        for (Turma turma : turmas) {
            for (Sala sala : salas) {
                if (alocar(turma, sala)) {
                    break;
                }
            }
        }
    }

    public int getTotalTurmasAlocadas() {
        int total = 0;
        for (TurmaEmSala ts : ensalamento) {
            if (ts.sala != null) {
                total++;
            }
        }
        return total;
    }

    public int getTotalEspacoLivre() {
        int total = 0;
        for (TurmaEmSala ts : ensalamento) {
            if (ts.sala != null) {
                total += ts.sala.capacidade - ts.turma.numAlunos;
            }
        }
        return total;
    }

    public String relatorioResumoEnsalamento() {
        return "Total de Salas: " + salas.size() + "\n" +
                "Total de Turmas: " + turmas.size() + "\n" +
                "Turmas Alocadas: " + getTotalTurmasAlocadas() + "\n" +
                "Espaços Livres: " + getTotalEspacoLivre() + "\n\n";
    }

    public String relatorioTurmasPorSala() {
        String relatorio = relatorioResumoEnsalamento() + "\n\n";

        for (Sala sala : salas) {
            relatorio += "--- " + sala.getDescricao() + " ---\n\n";

            for (TurmaEmSala ts : ensalamento) {
                if (ts.sala != null && ts.sala.equals(sala)) {
                    relatorio += ts.turma.getDescricao() + "\n\n";
                }
            }
        }
        return relatorio;
    }

    public String relatorioSalasPorTurma() {
        String relatorio = relatorioResumoEnsalamento();

        for (Turma turma : turmas) {
            relatorio += turma.getDescricao() + "\n";

            Sala sala = getSala(turma);
            if (sala != null) {
                relatorio += "Sala: " + sala.getDescricao() + "\n\n";
            } else {
                relatorio += "Sala: SEM SALA\n\n";
            }
        }
        return relatorio;
    }
}
