import java.util.Scanner;

class DataExtenso {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        String data = ler.nextLine();

        String stringDia = data.substring(0, 2);
        String stringMes = data.substring(2, 4);
        String stringAno = data.substring(4, 8);

        int dia = Integer.parseInt(stringDia);
        int ano = Integer.parseInt(stringAno);
        
        int intMes = Integer.parseInt(stringMes);



        switch(intMes){
            case 1:
                System.out.println(dia + " de janeiro de " + ano);
                break;
            
            case 2:
                System.out.println(dia + " de fevereiro de " + ano);
                break;

            case 3:
                System.out.println(dia + " de março de " + ano);
                break;

            case 4:
                System.out.println(dia + " de abril de " + ano);
                break;
            
            case 5:
                System.out.println(dia + " de maio de " + ano);
                break;

            case 6:
                System.out.println(dia + " de junho de " + ano);
                break;

            case 7:
                System.out.println(dia + " de julho de " + ano);
                break;

            case 8:
                System.out.println(dia + " de agosto de " + ano);
                break;

            case 9:
                System.out.println(dia + " de setembro de " + ano);
                break;

            case 10:
                System.out.println(dia + " de outubro de " + ano);
                break;

            case 11:
                System.out.println(dia + " de novembro de " + ano);
                break;
            case 12:
                System.out.println(dia + " de dezembro de " + ano);
                break;
            default:
                System.out.println("mes invalido");
                break;    

        
            }
        ler.close();
    }
}

