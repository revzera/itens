import java.util.Scanner;

public class TanqueCombustivel {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        double raioTanque = ler.nextDouble();
        double alturaAr = ler.nextDouble();
        int opcao = ler.nextInt();

        double pi = Math.PI;

        double volumeEsfera = (4.0 / 3.0) * pi * Math.pow(raioTanque, 3);
        double volumeAr = (pi / 3.0) * (alturaAr * alturaAr) * (3.0 * raioTanque - alturaAr);
        double volumeCombustivel = volumeEsfera - volumeAr;
        
        if(opcao == 1){ //volume do ar
            System.out.printf("%.4f", volumeAr);
        }
        if(opcao == 2){ //volume de combustivel do tanque
            System.out.printf("%.4f", volumeCombustivel);
        }
        ler.close();
    }    
}
