import java.util.Scanner;

public class SomaDigitos {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        int entrada = ler.nextInt();
        int soma = 0;

        while(entrada != 0){
            int digito = entrada %10;
            soma += digito;
            entrada /= 10;
        }

        System.out.println(soma);
        ler.close();
    }
}
