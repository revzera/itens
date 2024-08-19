import java.util.Scanner;

public class SomaColecao {
    public static void main(String[] args){    
        Scanner ler = new Scanner(System.in);
        
        int entrada = ler.nextInt();
        int soma = 0;

        while(entrada != -1){
            soma += entrada;
            entrada = ler.nextInt();
        }
        System.out.println(soma);
        ler.close();
    }
}
