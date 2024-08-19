import java.util.Scanner;

public class AreaVolume {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        double entrada = ler.nextDouble();
      
        double raio = entrada;
        double pi = Math.PI;
        double area = pi * (raio * raio);
        double volume = (4.0 /3.0) * pi * (raio * raio * raio);

        System.out.printf("Um circulo com raio de %.2f centimetros tem uma area de %.2f centimetros quadrados.", raio, area);
        System.out.printf("Uma esfera com raio de %.2f centimetros tem um volume de %.2f centimetros cubicos.", raio, volume);


        ler.close();
    }
}