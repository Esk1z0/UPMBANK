import java.util.Scanner;

public class Movimientos {
    public static int deposito(String Iban){
        int deposito = 0;
        Scanner emtrada = new Scanner(System.in);
        if (Long.parseLong(Iban) != 0) {
            System.out.println(Iban);
            System.out.println("Introduzca cuánto quiere ingresaren la cuenta " + Iban + " \n :");
            deposito = emtrada.nextInt();
            System.out.println("Se ha ingresado " + deposito + "\u20AC");
        }
        else{
            System.out.println("Desgraciadamente no tiene una cuenta a la que ingresar dinero");
            deposito = 0;
        }
        return deposito;
    }
    public static int retirada(String Iban){
        int retirada = 0;
        Scanner entrada = new Scanner(System.in);
        if (Long.parseLong(Iban) != 0) {
            System.out.println(Iban);
            System.out.println("Intreoduzca cuanto dinero quiere retirar de la cuenta " + Iban + " \n :");
            retirada = entrada.nextInt();
            System.out.println("Se ha retirado " + retirada + "\u20AC");
        }
        else{
            System.out.println("Desgraciadamente no tiene una cuenta de la que extraer dinero.");
            retirada = 0;
        }
        return retirada;
    }
}
