import java.util.Scanner;

public class OperacoesString {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        String nome = ler.nextLine();

        int tamNome = nome.length();
        String primeiraLetra = nome.substring(0, 1);
        String ultimaLetra = nome.substring(tamNome - 1);
        String maiuscula = nome.toUpperCase();
        String minuscula = nome.toLowerCase();
        String substituto = nome.replace('a', 'e');
        
        System.out.println(tamNome);
        System.out.println(primeiraLetra);
        System.out.println(ultimaLetra);
        System.out.println(maiuscula);
        System.out.println(minuscula);
        System.out.println(substituto);

        for (int i = 0; i < nome.length(); i += 2) {
            System.out.print(nome.charAt(i));
        }
        System.out.println();
        
        long quantidadeVogais = nome.codePoints()
            .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
            .count();
        System.out.println(quantidadeVogais);






        ler.close();
    }
}
