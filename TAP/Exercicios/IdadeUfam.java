import java.util.Scanner;

public class IdadeUfam {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        int entrada = ler.nextInt();

        int fundacao = 1909;

        int idade = entrada - fundacao;

        System.out.println("A UFAM tem "+ idade +" anos de fundacao");

        ler.close();
    }
}
