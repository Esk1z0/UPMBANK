import java.util.Scanner;

public class Movimientos {
    public static int deposito(String Iban){
        int deposito = 0;
        Scanner emtrada = new Scanner(System.in);
        if (Iban != "0") {
            System.out.println(Iban);
            System.out.println("Introduzca cuánto quiere ingresaren la cuenta " + Iban + " \n :");
            deposito = emtrada.nextInt();
            System.out.println("Se ha ingresado " + deposito + "\u20AC");
        }
        else if (Iban == "0"){
            System.out.println("Desgraciadamente no tiene una cuenta a la que ingresar dinero");
            deposito = 0;
        }
        return deposito;
    }
    public static int retirada(String Iban){
        int retirada = 0;
        Scanner entrada = new Scanner(System.in);
        if (Iban != "0") {
            System.out.println(Iban);
            System.out.println("Intreoduzca cuanto dinero quiere retirar de la cuenta " + Iban + " \n :");
            retirada = entrada.nextInt();
            System.out.println("Se ha retirado " + retirada + "\u20AC");
        }
        else if(Iban == "0") {
            System.out.println("Desgraciadamente no tiene una cuenta de la que extraer dinero.");
            retirada = 0;
        }
        return retirada;
    }

    //Hacer la transeferencia
    //Comprobar que el iban emisor está bien

    public static String ibanEmisor(){
        String ibanEmisor;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduzca el número de cuenta emisor: ");
        ibanEmisor = entrada.nextLine();

        return ibanEmisor;
    }
    public static String ibanReceptor(){
        String ibanReceptor;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduzca el número de cuenta receptor: ");
        ibanReceptor = entrada.nextLine();

        return ibanReceptor;
    }

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
