class Professor {
    String titulacao;
    String nome;
    int matricula;    

    Professor(){}

    public Professor(String titulacao, String nome, int matricula){
        this.titulacao = titulacao;
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getDescricao(){
        return "Prof. " + titulacao + " " + nome + " - mat " + matricula;
    }
}

