/**Comentário:
 * Se pesquisar como resolver o problema na internet, uma vez que eu não consegui, sim, plageei.
 * Mas não procurei ninguém pra me ajudar a resolver, muito menos numa turma onde não conheço ninguém.
 * Pesquisei sobre o problema de número narcisista e cheguei no Armstrong.
 * Pesquisei como implementar um contador de casas decimais (no código está como expo) e implementei, assinm como fiz na questão anterior.
 * E implementei o expo no 2° while, semelhante ao que fiz na questão anterior, mas usando a dica disponibilizada na questão.
 * Depois de testar várias vezes e dar erro sempre, pedi ajuda ao colega gpt para verificar o meu erro (depois de tentar descobrir sozinho e falhar), no final, eu simplesmente tinha que alterar o parâmetro do contador de casas decimais.
 * Fim.
 */
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

