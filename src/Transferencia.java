import java.util.Scanner;

public class Transferencia {
    //Hacer la transeferencia
    //Pedir el numero emisor
    public static String ibanEmisor(){
        String ibanEmisor;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduzca el número de cuenta emisor: ");
        ibanEmisor = entrada.nextLine();

        return ibanEmisor;
    }
    //Pedir el numero receptor
    public static String ibanReceptor(){
        String ibanReceptor;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduzca el número de cuenta receptor: ");
        ibanReceptor = entrada.nextLine();

        return ibanReceptor;
    }
    //Esto comprueba que los numeros de cuenta son del UPMBank
    public static boolean numTest(String iban){
        String comprobar = "0";
        long test;
        boolean prueba;

        for (int i = 0; i<=7; ++i){
            comprobar = comprobar + iban.charAt(i);
        }
        test = Long.parseLong(comprobar);
        if (test == 90100201){
            prueba = true;
        }
        else{
            prueba = false;
        }
        return prueba;
    }
    //Aquí se realiza la transferencia
    public static int transferencia(String ibanEmisor, String ibanReceptor){
        int dinero = 0;
        Scanner entrada = new Scanner(System.in);
        boolean prueba1, prueba2;
        prueba1 = numTest(ibanEmisor);
        prueba2 = numTest(ibanReceptor);
        if (prueba1 && prueba2) {
            System.out.println("Introduzca la cantidad que quiere transeferir: ");
            dinero = entrada.nextInt();
            System.out.println("Transferencia Realizada");
        }
        else{
            dinero = 0;
        }
        return dinero;
    }
}
