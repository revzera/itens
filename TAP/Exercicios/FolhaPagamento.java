import java.text.DecimalFormat;
import java.util.Scanner;

public class FolhaPagamento {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        double valorHora = ler.nextDouble();
        int horas = ler.nextInt();

        double salarioBruto = horas * valorHora;

        double percentualINSS = 8.0 / 100.0;
        double percentualIR = 11.0 / 100.0;

        double impostoRenda = (percentualIR * salarioBruto);
        double inss = (percentualINSS * salarioBruto);

        double descontos = inss + impostoRenda;

        double salarioLiquido = salarioBruto - descontos;

        DecimalFormat formato = new DecimalFormat("###0.00");

        System.out.println("Salario bruto: R$" + formato.format(salarioBruto));
        System.out.println("IR: R$" + formato.format(impostoRenda));
        System.out.println("INSS: R$" + formato.format(inss));
        System.out.println("Total de descontos: R$" + formato.format(descontos));
        System.out.println("Salario liquido: R$" + formato.format(salarioLiquido));
        ler.close();
    }
}
