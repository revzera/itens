import java.util.Scanner;

public class CifraCesar {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int deslocamento = ler.nextInt();
        String textoOriginal = ler.nextLine().trim();

        String textoCriptografado = criptografarCesar(textoOriginal, deslocamento);

        System.out.println(textoCriptografado);

        ler.close();
    }

    private static String criptografarCesar(String texto, int deslocamento) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caractereOriginal = texto.charAt(i);

            if (Character.isLetter(caractereOriginal)) {
                char caractereCifrado;
                if (Character.isUpperCase(caractereOriginal)) {
                    caractereCifrado = (char) ((caractereOriginal - 'A' + deslocamento) % 26 + 'A');
                } else {
                    caractereCifrado = (char) ((caractereOriginal - 'a' + deslocamento) % 26 + 'A');
                }
                resultado.append(caractereCifrado);
            } else {
                resultado.append(caractereOriginal);
            }
        }

        return resultado.toString();
    }
}
