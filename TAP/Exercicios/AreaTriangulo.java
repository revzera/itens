import java.util.Scanner;

public class AreaTriangulo {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        int numA = ler.nextInt();
        int numB = ler.nextInt();
        int numC = ler.nextInt();

        double s = (numA + numB + numC) /2;

        if(numA + numB <= numC || numA + numC <= numB || numB + numC <= numA){
            System.out.println("Triangulo invalido");
        }

        else{
            double area = s * (s-numA) * (s-numB) * (s-numC);
            double raizArea = Math.sqrt(area);
            
            System.out.printf("%.2f\n", raizArea);
            
        }
            ler.close();
    }
}
