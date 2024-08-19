import java.util.Scanner;

public class ValorExpoente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int limite = scanner.nextInt();

        int soma = 0;
        int expoente = 1;

        while (soma <= limite) {
            soma += Math.pow(2, expoente);
            expoente++;
        }

        System.out.println(expoente - 1);

        scanner.close();
    }
}
