import java.util.Scanner;

public class ContaEnergia {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        double entradaConsumo = ler.nextDouble();
        char letra = ler.next().charAt(0);
        double precoFinal = -1.0;

        switch (letra) {
            case 'R':
                if (entradaConsumo > 0) {
                    if (entradaConsumo <= 500) {
                        precoFinal = entradaConsumo * 0.40;
                    } else {
                        precoFinal = entradaConsumo * 0.65;
                    }
                }
                break;

            case 'C':
                if (entradaConsumo > 0) {
                    if (entradaConsumo <= 1000) {
                        precoFinal = entradaConsumo * 0.55;
                    } else {
                        precoFinal = entradaConsumo * 0.60;
                    }
                }
                break;

            case 'I':
                if (entradaConsumo > 0) {
                    if (entradaConsumo <= 5000) {
                        precoFinal = entradaConsumo * 0.55;
                    } else {
                        precoFinal = entradaConsumo * 0.60;
                    }
                }
                break;
        }

        if (precoFinal != -1.0) {
            System.out.printf("%.2f%n", precoFinal);
        } else {
            System.out.println("-1.00");
        }

        ler.close();
    }
}
