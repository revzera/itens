public class Main {
    public static void main(String[] args) {
        Ensalamento ensalamento = new Ensalamento();

        Sala sala101 = new Sala(6, 101, 50, true);
        Sala sala102 = new Sala(6, 102, 100, true);
        Sala sala203 = new Sala(6, 203, 50, false);

        ensalamento.addSala(sala101);
        ensalamento.addSala(sala102);
        ensalamento.addSala(sala203);

        Turma turma1 = new Turma("Técnicas de Programação", "Horácio Fernandes", 50, false);
        turma1.addHorario(2); // Terça 14hs
        turma1.addHorario(4); // Quinta 14hs
        turma1.addHorario(5); // Sexta 14hs

        Turma turma2 = new Turma("Laboratório de Programação C", "Edson Nascimento", 25, true);
        turma2.addHorario(1); // Segunda 8hs
        turma2.addHorario(3); // Quarta 8hs
        turma2.addHorario(5); // Sexta 8hs

        Turma turma3 = new Turma("Algoritmos e Estrutura de Dados I", "Edleno Silva", 60, false);
        turma3.addHorario(1); // Segunda 8hs
        turma3.addHorario(3); // Quarta 8hs
        turma3.addHorario(5); // Sexta 8hs

        ensalamento.addTurma(turma1);
        ensalamento.addTurma(turma2);
        ensalamento.addTurma(turma3);

        // Realizar alocação
        ensalamento.alocarTodas();

        // Exibir relatórios
        System.out.println(ensalamento.relatorioResumoEnsalamento());
        System.out.println("\nRelatório Turmas Por Sala:\n" + ensalamento.relatorioTurmasPorSala());
        System.out.println("\nRelatório Salas Por Turma:\n" + ensalamento.relatorioSalasPorTurma());
    }
}
