import java.util.Scanner;

public class TipoTriangulo {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        double a = ler.nextDouble();
        double b = ler.nextDouble();
        double c = ler.nextDouble();

        if((a + b <= c || a + c <= b || b + c <= a) || (a <= 0 || b <= 0 || c <= 0)){
            System.out.println("invalido");
        }
        else if(a == b && b == c){
            System.out.println("equilatero");
        }
        else if(a == b || b == c){
            System.out.println("isosceles");
        }
        else{
            System.out.println("escaleno");
        }
        ler.close();
    }
}