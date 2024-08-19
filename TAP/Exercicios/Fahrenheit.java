import java.util.Scanner;

public class Fahrenheit {
    public static void main(String[] args){
        Scanner  ler = new Scanner(System.in);

        double c = ler.nextDouble();

        double fahrenheit = (( 9 * c) / 5) + 32;

        System.out.printf("%.1f\n", fahrenheit);
        ler.close();
    }
}
