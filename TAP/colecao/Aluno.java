import java.util.Calendar;

class Aluno{
    String nome;
    int matricula;
    int anoNascimento;
    int ano = Calendar.getInstance().get(Calendar.YEAR);
    
    Aluno(){}

    public Aluno(String nome, int matricula, int anoNascimento){
        this.nome = nome;
        this.matricula = matricula;
        this.anoNascimento = anoNascimento;
    }
    
    public int getMatricula(){
        return matricula;
    }

    public int getIdade(){
        int idade = ano - anoNascimento;
        return idade;
    }
        
    public String getDescricao(){
        return nome + " (mat=" + matricula + ", idade="+ getIdade() + ")";
    }

}