import java.util.Scanner;

public class funciones {
    String NC_1, NC_2;

    public static boolean letraDNI(char a, long b){
        String cadena = "TRWAGMYFPDXBNJZSQVHLCKE";
        int d = (int)b%23;
        if (cadena.charAt(d) == a){
            return true;
        }
        else{
            return false;
        }
    }


    public static void registro(){
        //Aqui pedimos el nombre al maromo

        String nombre, apellidos;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Para crear una cuenta en UPMBank se le va a pedir una serie de datos");
        System.out.print("Nombre: ");
        nombre = entrada.nextLine();
        System.out.print("\nApellidos: ");
        apellidos = entrada.nextLine();

        //Aquí pedimos la fecha de nacimiento

        int diaNac, mesNac, añoNac;

        System.out.print("\nDía de nacimiento (dd): ");
        diaNac = entrada.nextInt();
        System.out.print("\nMes de nacimiento (mm): ");
        mesNac = entrada.nextInt();
        System.out.print("\nAño de nacimiento (aa): ");
        añoNac = entrada.nextInt();
        System.out.printf("\nSu fecha de nacimiento es: %02d/%02d/%02d", diaNac, mesNac, añoNac);
        //Aquí pedimos el dni y comprobamos que es verdadera

        char letradni;
        int tipoCuenta;
        long numDNI;
        boolean pruebaDNI;

        do {
            System.out.print("\nDeme los números de su DNI: ");
            numDNI = entrada.nextLong();
            if (numDNI > 99999999)
                System.out.println("Error, numero muy largo");
            else
                System.out.println("Número aceptado");
            System.out.print("\nAhora introduzca la letra de su DNI: ");
            letradni = entrada.next().charAt(0);
            pruebaDNI = funciones.letraDNI(letradni, numDNI);
        }while (pruebaDNI == false);

        //Ahora se valida el correo electronico

        String correo = "a";

        do{
            System.out.println("\nIntroduzca un correo válido de la UPM:");
            correo = entrada.nextLine();
        }while (!correo.contains("@alumnos.upm.es") && !correo.contains("@upm.es"));


        System.out.print("\nSu cuenta ya está regitrada. Felicidades");


    }
//esto esta en proceso juanes
    public static void numCuenta(){
        long CE = 9010;
        long CS = 0201;
        long NC = 0;
        double num = 0;
        for(int i = 0; i<=11; ++i){
            System.out.println(Math.random());
        }
        num = Math.random();
        System.out.println(num);
        NC = (long)(num*10);
        System.out.println(NC);



    }




    public static void cuenta(){
        String cliente;
        int tipoCuenta;
        String numeroBanco;

        Scanner entrada = new Scanner(System.in);
        System.out.print("Ha seleccionado crear una cuenta");
        System.out.print("\nDeme un nombre: ");
        cliente = entrada.nextLine();
        System.out.print("\nAhora elija un tipo de cuenta\n(1)Corriente (2)Ahorro (3)Remunerada");
        tipoCuenta = entrada.nextInt();
        System.out.println("\nSu número de cuenta es:\n");



    }
    public static void main(String[] args) {
        numCuenta();
    }



}
