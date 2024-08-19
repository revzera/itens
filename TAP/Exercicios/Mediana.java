import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Mediana {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        int entrada = ler.nextInt();
        
        while(entrada != -1){
            numbers.add(entrada);
            entrada = ler.nextInt();
        }

        double mediana;
        int tamanho = numbers.size();

        if(tamanho % 2 == 0){
            int indicePar = tamanho / 2 - 1;
            int indiceImpar = tamanho / 2;

            int valor1 = numbers.get(indicePar);
            int valor2 = numbers.get(indiceImpar);

            mediana = (valor1 + valor2) / 2.0;
        }
        else{
            int indice = tamanho / 2;
            mediana = numbers.get(indice);
            
        }

        System.out.printf("%.1f%n", mediana);

        ler.close();
    }   
}
