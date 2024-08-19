import java.util.Scanner;

public class MediaColecoes {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        int entrada = ler.nextInt();
        
        while(entrada != -1){
            double soma = 0;
            double cont = 0;

            while(entrada != -1){
                soma += entrada;
                cont++;
                entrada = ler.nextInt();
            }
            double media = soma/cont;
            System.out.printf("%.2f\n", media);
            soma = 0;
            cont = 0;
            
            if(entrada != 1){
                entrada = ler.nextInt();
            }
        }
    ler.close();
    }    
}
