import java.util.Scanner;

public class AproximacaoSeno {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        double anguloGraus = ler.nextDouble();
        int entrada = ler.nextInt();
        double anguloRadianos = Math.toRadians(anguloGraus);

        double seno = 0.0;

        for (int i = 0; i < entrada; i++) {
            seno += Math.pow(-1, i) * Math.pow(anguloRadianos, 2 * i + 1) / fatorial(2 * i + 1);
            System.out.printf("%.10f\n", seno);
        }

        ler.close();
    }

    private static double fatorial(int n) {
        double resultado = 1.0;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}


