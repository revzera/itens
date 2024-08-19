import java.util.Scanner;

public class Xadrez {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);

        int entrada = scan.nextInt();

        for(int i = 0; i < entrada; i++){
            for(int j = 0; j < entrada * 2; j++){
                if((i + j) % 2 == 0){
                    System.out.print("*");                
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        scan.close();
    }
}