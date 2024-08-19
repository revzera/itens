import java.util.Scanner;

public class RaizQuadrada {
    public static void main(String[] args){
        
        Scanner ler = new Scanner(System.in);

        double entrada = ler.nextDouble();

        double raiz = Math.sqrt(entrada);

        System.out.printf("%4f\n", raiz);

        ler.close();
    }
}
