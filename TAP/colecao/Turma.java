import java.util.ArrayList;

class Turma {
    String disciplina;
    int ano;
    int semestre;
    Professor professor;
    ArrayList<Aluno> alunos;

    Turma(String disciplina, int ano, int semestre, Professor professor){
        this.disciplina = disciplina;
        this.ano = ano;
        this.semestre = semestre;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    void addAluno(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getMatricula() == aluno.getMatricula()) {
                return;
            }
        }
        alunos.add(aluno);
    }

    Aluno getAluno(int matricula){
        for(Aluno aluno : alunos){
            if(aluno.getMatricula() == matricula){
                return aluno;
            }
        }
        return null;
    }

    double getMediaIdade(){
        int somaIdades = 0;
        for(Aluno aluno : alunos){
            somaIdades += aluno.getIdade();
        }

        return (double) somaIdades / alunos.size();
    }

    String getDescricao(){
        String prof = "Prof. " + professor.titulacao + " " + professor.nome + " - mat " + professor.matricula;
        String slc = "Turma " + disciplina + " - " + ano + "/" + semestre + " (" + prof + "):\n";
        
        int i = 1;
        
        for(Aluno aluno : alunos){
            slc += "  - Aluno " + i + ": " + aluno.getDescricao() + "\n";
            i++;
        }
        return slc;
    }
    

}



