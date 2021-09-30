import java.util.Scanner;

public class Sign_In {
    public static void main(String[] args) {

        String nombre, apellidos;
        String letraDNI;
        int tipoCuenta, fechaNac, diaNac, mesNac, añoNac, pruebaDNI;
        long IBAN, numDNI;

        //Aqui pedimos el nombre al maromo

        Scanner entrada = new Scanner(System.in);
        System.out.println("Para crear una cuenta en UPMBank se le va a pedir una serie de datos");
        System.out.print("Nombre: ");
        nombre = entrada.nextLine();
        System.out.print("\nApellidos: ");
        apellidos = entrada.nextLine();

        //Aquí pedimos la fecha de nacimiento

        System.out.print("\nDía de nacimiento (dd): ");
        diaNac = entrada.nextInt();
        System.out.print("\nMes de nacimiento (mm): ");
        mesNac = entrada.nextInt();
        System.out.print("\nAño de nacimiento (aa): ");
        añoNac = entrada.nextInt();
        System.out.printf("\nSu fecha de nacimiento es: %02d/%02d/%02d", diaNac, mesNac, añoNac);

        //Aquí pedimos el dni y comprobamos que es verdadera

        System.out.print("\nDeme los números de su DNI: ");
        numDNI = entrada.nextLong();
        if (numDNI > 99999999)
            System.out.println("Error, numero muy largo");
        else
            System.out.println("Número aceptado");
        System.out.print("\nAhora introduzca la letra de su DNI: ");
        letraDNI = entrada.next();
        pruebaDNI = (int)(numDNI % 23);
        switch (pruebaDNI){
            case 0:

            case 1:

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:

            case 8:

            case 9:

            case 10:

            case 11:

            case 12:

            case 13:

            case 14:

            case 15:

            case 16:

            case 17:

            case 18:

            case 19:

            case 20:

            case 21:

            case 22:

            default:
        }



    }
}
