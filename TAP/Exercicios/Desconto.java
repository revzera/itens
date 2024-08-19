import java.util.Scanner;

public class Desconto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double precoOriginal = scan.nextDouble();
        double desconto = 0.05 * precoOriginal;
        double precoComDesconto = precoOriginal - desconto;

        if(precoOriginal >= 200){
            System.out.printf("%.2f%n", precoComDesconto);
        }
        else{
            System.out.printf("%.2f%n", precoOriginal);
        }
        scan.close();
    }
}