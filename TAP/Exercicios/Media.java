import java.util.Scanner;

class Media{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        double entrada1 = scan.nextDouble();
        double entrada2 = scan.nextDouble();
        double entrada3 = scan.nextDouble();

        double media = (entrada1 + entrada2 + entrada3) / 3;

        System.out.printf("%.2f\n", media);

        scan.close();
    }
}
