import java.util.Scanner;

public class OperacoesInteiros {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        
        int entrada = ler.nextInt();
        
        while(entrada != -1){
            int quantElementos = 0;
            int quantPares = 0;
            int quantImpares = 0;
            int somaTotal = 0;
            int maior = Integer.MIN_VALUE;
            int menor = Integer.MAX_VALUE;

            while(entrada != -1){
                quantElementos++;
                somaTotal += entrada;

                if(entrada % 2 == 0){
                    quantPares++;
                }else{
                    quantImpares++;
                }
                
                maior = Math.max(maior, entrada);
                menor = Math.min(menor, entrada);
                
                entrada = ler.nextInt();
            }

            if(quantElementos > 0){
                double media = (double) somaTotal / quantElementos;

                System.out.println(quantElementos);
                System.out.println(quantPares);
                System.out.println(quantImpares);
                System.out.println(somaTotal);
                System.out.printf("%.2f%n", media);
                System.out.println(maior);
                System.out.println(menor);
            }

            entrada = ler.nextInt();

        }


        ler.close();
    }
}
