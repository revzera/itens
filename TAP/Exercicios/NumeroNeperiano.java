import java.util.Scanner;

public class NumeroNeperiano {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int entrada = ler.nextInt();
        double neperiano = 1.0;

        for (int i = 1; i < entrada; i++) {
            neperiano += 1.0 / fatorial(i);
        }

        System.out.printf("%.6f\n", neperiano);

        ler.close();
    }

    private static int fatorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fatorial(n - 1);
        }
    }
}
