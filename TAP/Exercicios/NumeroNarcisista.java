import java.util.Scanner;

public class NumeroNarcisista {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        int entrada = ler.nextInt();
        int original = entrada;
        int soma = 0;
        int temp = entrada;

//contador de expoente        
        int expo = 0;
        while(temp != 0){
            temp /= 10;
            expo++;
        }


        while(entrada != 0){
            int digito = entrada % 10;
            soma += Math.pow(digito, expo);
            entrada /= 10;
        }
        if(soma == original){
            System.out.println("SIM");
        }
        else{
            System.out.println("NAO");

        }            
        ler.close();
    }

}

