import java.util.Scanner;

public class PorcentagemAcerto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] respostas = lerVetor(scanner);

        int[] gabarito = lerVetor(scanner);

        double porcentagemAcerto = calcularPorcentagemAcerto(respostas, gabarito);

        System.out.printf("%.2f", porcentagemAcerto);
    }

    private static int[] lerVetor(Scanner scanner) {
        int tamanho = 0;
        int[] vetor = new int[100];

        while (true) {
            int valor = scanner.nextInt();
            if (valor == -1) {
                break;
            }
            vetor[tamanho] = valor;
            tamanho++;
        }

        int[] resultado = new int[tamanho];
        System.arraycopy(vetor, 0, resultado, 0, tamanho);
        return resultado;
    }
    private static double calcularPorcentagemAcerto(int[] respostas, int[] gabarito) {
        int totalPerguntas = respostas.length;
        int acertos = 0;

        for (int i = 0; i < totalPerguntas; i++) {
            if (respostas[i] == gabarito[i]) {
                acertos++;
            }
        }

        return ((double) acertos / totalPerguntas) * 100;
    }
}
