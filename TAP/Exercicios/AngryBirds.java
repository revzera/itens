import java.util.Scanner;

public class AngryBirds {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        double v0 = ler.nextDouble();
        double alpha = ler.nextDouble();
        double distancia = ler.nextDouble();

        double g = 9.8;
        //double a = 2 * alpha;
        double radiano = Math.toRadians(alpha);
        double alcance = (v0 * v0 * Math.sin(2 * radiano)) / g;

        if((distancia - alcance <= 0.1) || (distancia - 0.01 <= alcance)){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        ler.close();
        }

    }
}
