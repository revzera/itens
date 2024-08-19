import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class TimeFutebol {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        List<Integer> nros1 = new ArrayList<>();
        List<Integer> nros2 = new ArrayList<>();

        int entrada = ler.nextInt();

        
        while(entrada != -1){
            nros1.add(entrada);
            entrada = ler.nextInt();
        }
        
        int entrada2 = ler.nextInt();

        while(entrada2 != -1){
            nros2.add(entrada2);
            entrada2 = ler.nextInt();
        }
        
        int sizeNros1 = nros1.size();
        //int sizeNros2 = nros2.size();

        //if(sizeNros1 != sizeNros2){
        //    break;
        //}

        int vitorias = 0;
        int empates = 0;
        int derrotas = 0;

        for(int i = 0; i < sizeNros1; i++){
            if(nros1.get(i) > nros2.get(i)){
                vitorias++;
            }
            else if(nros1.get(i).equals(nros2.get(i))){
                empates++;
            }
            else{
                derrotas++;
            }
        }

        System.out.println(vitorias + " " + empates + " " + derrotas);

        ler.close();
    }
}
