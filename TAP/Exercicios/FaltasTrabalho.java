import java.util.Scanner;

public class FaltasTrabalho {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int[] historicoFaltas = new int[7];
        int falta;

        while (true) {
            falta = ler.nextInt();

            if (falta == -1) {
                break;
            }

            if (falta >= 1 && falta <= 7) {
                historicoFaltas[falta - 1]++;
            }
        }

        imprimirPercentualFaltas(historicoFaltas);

        ler.close();
    }

    private static void imprimirPercentualFaltas(int[] historicoFaltas) {
        int totalFaltas = 0;

        for (int faltasDia : historicoFaltas) {
            totalFaltas += faltasDia;
        }

        for (int i = 1; i < historicoFaltas.length; i++) {
            double percentual = (double) historicoFaltas[i] / totalFaltas * 100;
            System.out.printf("%.1f ", percentual);
        }

        System.out.println();
    }
}
