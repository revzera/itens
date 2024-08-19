public class TurmaMain {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Ricas From Brazil", 22052575, 2001);
        Aluno aluno2 = new Aluno("Max Verstappen", 1, 1999);
        Aluno aluno3 = new Aluno("Charles Leclerc", 5907, 2001);
        Aluno aluno4 = new Aluno("Lewis Hamilton", 7734, 2002);

        Professor professor = new Professor("Dr.", "Horacinho Verstappen", 3698);

        Turma turma = new Turma("Formula 1", 2023, 2, professor);

        turma.addAluno(aluno1);
        turma.addAluno(aluno2);
        turma.addAluno(aluno3);
        turma.addAluno(aluno4);

        System.out.println(turma.getDescricao());
    }
}