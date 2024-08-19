import java.util.ArrayList;

public class Turma {
    String nome;
    String professor;
    int numAlunos;
    boolean acessivel;
    ArrayList<Integer> horarios;

    Turma(){}

    Turma(String nome, String professor, int numAlunos, boolean acessivel){
        this.nome = nome;
        this.professor = professor;
        this.numAlunos = numAlunos;
        this.acessivel = acessivel;        
        this.horarios = new ArrayList<>();
    }

    void addHorario(int horario){
        horarios.add(horario);
    }

    String getHorariosString(){
        String dia = "";

        int cont = 0;
                        
        for(Integer horario : horarios){
            switch(horario){
                case 1:
                    dia += "segunda 8hs";
                    break;
                case 2:
                    dia += "segunda 10hs";
                    break;
                case 3:
                    dia += "segunda 12hs";
                    break;
                case 4:
                    dia += "segunda 14hs";
                    break;
                case 5:
                    dia += "segunda 16hs";
                    break;
                case 6:
                    dia += "segunda 18hs";
                    break;
                case 7:
                    dia += "segunda 20hs";
                    break;
                case 8:
                    dia += "terça 8hs";
                    break;
                case 9:
                    dia += "terça 10hs";
                    break;
                case 10:
                    dia += "terça 12hs";
                    break;
                case 11:
                    dia += "terça 14hs";
                    break;
                case 12:
                    dia += "terça 16hs";
                    break;
                case 13:
                    dia += "terça 18hs";
                    break;
                case 14:
                    dia += "terça 20hs";
                    break;
                case 15:
                    dia += "quarta 8hs";
                    break;
                case 16:
                    dia += "quarta 10hs";
                    break;
                case 17:
                    dia += "quarta 12hs";
                    break;
                case 18:
                    dia += "quarta 14hs";
                    break;
                case 19:
                    dia += "quarta 16hs";
                    break;
                case 20:
                    dia += "quarta 18hs";
                    break;
                case 21:
                    dia += "quarta 20hs";
                    break;
                case 22:
                    dia += "quinta 8hs";
                    break;
                case 23:
                    dia += "quinta 10hs";
                    break;
                case 24:
                    dia += "quinta 12hs";
                    break;
                case 25:
                    dia += "quinta 14hs";
                    break;
                case 26:
                    dia += "quinta 16hs";
                    break;
                case 27:
                    dia += "quinta 18hs";
                    break;
                case 28:
                    dia += "quinta 20hs";
                    break;
                case 29:
                    dia += "sexta 8hs";
                    break;
                case 30:
                    dia += "sexta 10hs";
                    break;
                case 31:
                    dia += "sexta 12hs";
                    break;
                case 32:
                    dia += "sexta 14hs";
                    break;
                case 33:
                    dia += "sexta 16hs";
                    break;
                case 34:
                    dia += "sexta 18hs";
                    break;
                case 35:
                    dia += "sexta 20hs";
                    break;
            }
            cont++;
            
            if(cont != horarios.size()){
                dia += ", ";
            }

        }
        return dia;
    }

    String getDescricao(){
        String descricao = "Turma: " + nome + "\n";
        descricao += "Professor: " + professor + "\n";
        descricao += "Número de Alunos: " + numAlunos + "\n";
        descricao += "Horário: " + getHorariosString() + "\n";
        descricao += "Acessível: " + (acessivel ? "sim" : "não");
        return descricao;
    }

    
}
