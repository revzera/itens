import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args){

        Scanner ler = new Scanner(System.in);

        while(true){   
            int entrada = ler.nextInt();
    
            if(entrada == -1){
                break;
            }
            if(entrada % 2 == 0){
                System.out.println("PAR");
            }
            else{
                System.out.println("IMPAR");
            }
        }
        ler.close();
    }
}