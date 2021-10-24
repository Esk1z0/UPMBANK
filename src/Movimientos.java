import java.util.Scanner;

public class Movimientos {
    public static int deposito(String Iban){
        int deposito = 0;
        Scanner emtrada = new Scanner(System.in);
        System.out.println(Iban);
        System.out.println("Introduzca cuánto quiere ingresaren la cuenta " + Iban + " : \n");
        deposito = emtrada.nextInt();
        System.out.println("Se ha ingresado " + deposito + "\u20AC");
        return deposito;
    }
}
