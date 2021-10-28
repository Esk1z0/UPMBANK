import java.util.Scanner;

public class Principal {

    public static void menu(){
        long eleccion = 0;
        long balance = 0, ultimoDeposito = 0, ultimaExtraccion = 0, ultimaTransferencia = 0;
        long capitalPrestamo = 0, tiempoPrestamo = 0;
        double cuota = 0, interes = 0.03;
        String nombre = "0", IBAN = "0", correo = "0", fechaNacimiento = "0",DNI = "0", DNIletra,ibanEmisor = "0", ibanreceptor = "0";
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bienvenido, ¿qué desea?");
        do{
            System.out.print(" Darse de Alta(1)  Crear una cuenta(2)  Depósito(3)  Extración(4)  \n Transferencia(5)  Hipotecarse(6)       Mi Cuenta(7) Salir(0)\n:");
            eleccion = entrada.nextInt();

            if (eleccion == 1) {
                //funcion darse de alta
                nombre = nombre();
                fechaNacimiento = fechaNacimiento();
                DNI = DNInum();
                DNIletra = letraDNI(Long.parseLong(DNI));
                DNI = DNI + DNIletra;
                correo = correo();
            }
            else if (eleccion == 2) {
                //funcion crear cuenta
                IBAN = cuenta();
            }
            else if (eleccion == 3) {
                //funcion deposito
                ultimoDeposito = Movimientos.deposito(IBAN);
                balance = balance + ultimoDeposito;
            }
            else if (eleccion == 4) {
                //funcion extraccion
                ultimaExtraccion = Movimientos.retirada(IBAN);
                balance = balance - ultimaExtraccion;
            }
            else if (eleccion == 5) {
                //funcion transferencia
                ibanEmisor = Movimientos.ibanEmisor();
                ibanreceptor = Movimientos.ibanReceptor();
                ultimaTransferencia = Movimientos.transferencia(ibanEmisor, ibanreceptor);
                balance = balance - ultimaTransferencia;
            }
            else if (eleccion == 6) {
                //funcion hipotecarse
                capitalPrestamo = Prestamo.hipoteca();
                balance = balance + capitalPrestamo;
                tiempoPrestamo = Prestamo.meses();
                cuota = Prestamo.cuota(tiempoPrestamo, capitalPrestamo, interes);
                Prestamo.tablaAmortización(capitalPrestamo, tiempoPrestamo, cuota, interes);
            }
            else if (eleccion == 7) {
                //funcion mi cuenta
                Datos.Micuenta(balance, ultimoDeposito, ultimaExtraccion, ultimaTransferencia, ibanEmisor, ibanreceptor, capitalPrestamo, tiempoPrestamo, cuota, interes, nombre, IBAN, correo, fechaNacimiento, DNI);
            }
            else if (eleccion == 0){
                System.out.println("Vuelva pronto");
            }
            else {
                System.out.println("Opción Inválida");
            }
        }while(eleccion != 0);
    }

    public static void main(String[] args) {
        menu();
    }
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
    public static String IBAN(){
        String CE = "9010";
        String CS = "0201";
        long NC = 0;
        int c1, c2;
        String Iban;

        //Aquí se calcula NC
        int d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
        long test = (long)Math.pow(10.0,9.0);
        d1 =(int) (Math.random()*10);
        d2 =(int) (Math.random()*10);
        d3 =(int) (Math.random()*10);
        d4 =(int) (Math.random()*10);
        d5 =(int) (Math.random()*10);
        d6 =(int) (Math.random()*10);
        d7 =(int) (Math.random()*10);
        d8 =(int) (Math.random()*10);
        d9 =(int) (Math.random()*10);
        d10 =(int) (Math.random()*10);

        NC = Math.abs((d1*1000000000)+(d2*100000000)+(d3*10000000)+(d4*1000000)+(d5*100000)+(d6*10000)+(d7*1000)+(d8*100)+(d9*10)+(d10));
        if (NC < test){
            NC = NC + test;
        }

        //Aquí se calcula c1
        c1 = c1(CE, CS);
        c2 = c2(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);

        Iban = CE + CS + String.valueOf(c1) + String.valueOf(c2) + String.valueOf(NC);
        return Iban;

    }


    public static int c1(String CE, String CS){
        int num, a1, a2, a3, a4, b1, b2, b3, b4, r, c;
        int c1 = 0;

        //Aquí meto las variables
        a1 = Character.getNumericValue(CE.charAt(0));
        a2 = Character.getNumericValue(CE.charAt(1));
        a3 = Character.getNumericValue(CE.charAt(2));
        a4 = Character.getNumericValue(CE.charAt(3));
        b1 = Character.getNumericValue(CS.charAt(0));
        b2 = Character.getNumericValue(CS.charAt(1));
        b3 = Character.getNumericValue(CS.charAt(2));
        b4 = Character.getNumericValue(CS.charAt(3));
        //Aqui hago los cálculos

        num = (6*b4)+(3*b3)+(7*b2)+(9*b1)+(10*a4)+(5*a3)+(8*a2)+(4*a1);
        r = num%11;
        c = 11-r;

        if (c<10){
            c1 = c;
        }
        else if (c==11){
            c1 = 0;
        }
        else if (c==10){
            c1 = 1;
        }
        return c1;
    }

    public static int c2(int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9, int d10){
        int num, r, c;
        int c2 = 0;

        num = (d1)+(2*d2)+(4*d3)+(8*d4)+(5*d5)+(10*d6)+(9*d7)+(7*d8)+(3*d9)+(6*d10);
        r = num % 11;
        c = 11 - r;
        if (c<10){
            c2 = c;
        }
        else if (c == 11){
            c2 = 0;
        }
        else if (c == 10){
            c2 = 1;
        }
        return c2;
    }





    public static String cuenta() {
        String cliente;
        int tipoCuenta;
        String numeroBanco;
        String Iban = "0";
        long money = 0;

        Scanner entrada = new Scanner(System.in);
        System.out.print("Ha seleccionado crear una cuenta");
        System.out.print("\nDeme un nombre: ");
        cliente = entrada.nextLine();
        System.out.print("\nAhora elija un tipo de cuenta\n(1)Corriente (2)Ahorro (3)Remunerada");
        tipoCuenta = entrada.nextInt();
        System.out.println("\nSu número de cuenta es:\n");
        Iban = IBAN();
        System.out.println(Iban);
        System.out.println("Se ha creado su cuenta, contiene " + money + "\u20AC"+ " ");
        System.out.println("Aceptar(1)");
        System.out.println(" ");
        return Iban;
    }
}
