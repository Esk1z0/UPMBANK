import java.util.Scanner;

public class NuevaCuenta {
    //Aqui pedimos el nombre al maromo
    public static String nombre(){
        String nombre, apellidos;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Para crear una cuenta en UPMBank se le va a pedir una serie de datos");
        System.out.print("Nombre: ");
        nombre = entrada.nextLine();
        System.out.print("\nApellidos: ");
        apellidos = entrada.nextLine();

        return nombre + " " + apellidos;
    }
    //Aquí pedimos la fecha de nacimiento
    public static String fechaNacimiento(){
        int diaNac, mesNac, añoNac;
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nDía de nacimiento (dd): ");
        diaNac = entrada.nextInt();
        System.out.print("\nMes de nacimiento (mm): ");
        mesNac = entrada.nextInt();
        System.out.print("\nAño de nacimiento (aa): ");
        añoNac = entrada.nextInt();
        System.out.printf("\nSu fecha de nacimiento es: %02d/%02d/%02d", diaNac, mesNac, añoNac);

        return String.valueOf(diaNac + mesNac + añoNac);
    }
    //Aquí pedimos el dni
    public static String DNInum(){
        char letradni;
        String DNI;
        boolean pruebaDNI;
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nDeme los números de su DNI: ");
        DNI = entrada.nextLine();
        while (Long.parseLong(DNI) > 99999999 || Long.parseLong(DNI) < 0) {
            System.out.println("Error, numero muy largo");
        }
        System.out.println("Número aceptado");

        return DNI;
    }
    //Aquí comprobamos la letra del DNI
    public static String letraDNI(long DNInum){
        char letradni;
        String cadena = "TRWAGMYFPDXBNJZSQVHLCKE";
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nAhora introduzca la letra de su DNI: ");
        letradni = entrada.next().charAt(0);

        int d = (int)DNInum%23;
        if (cadena.charAt(d) == letradni){
            System.out.println("Letra correcta. DNI Aceptado");
        }
        else{
            System.out.println("DNI incorrecto, vuelva a iniciar el proceso de registro");
        }

        return Character.toString(letradni);
    }
    //Aquí le pedimos el correo
    public static String correo(){
        //Ahora se valida el correo electronico
        Scanner entrada = new Scanner(System.in);
        String correo = "a";
        do{
            System.out.println("\nIntroduzca un correo válido de la UPM:");
            correo = entrada.nextLine();
        }while (!correo.contains("@alumnos.upm.es") && !correo.contains("@upm.es"));
        System.out.print("\nSu cuenta ya está regitrada. Felicidades\n");

        return correo;
    }
}
