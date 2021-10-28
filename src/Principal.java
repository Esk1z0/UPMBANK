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
                ultimoDeposito = deposito(IBAN);
                balance = balance + ultimoDeposito;
            }
            else if (eleccion == 4) {
                //funcion extraccion
                ultimaExtraccion = retirada(IBAN);
                balance = balance - ultimaExtraccion;
            }
            else if (eleccion == 5) {
                //funcion transferencia
                ibanEmisor = ibanEmisor();
                ibanreceptor = ibanReceptor();
                ultimaTransferencia = transferencia(ibanEmisor, ibanreceptor);
                balance = balance - ultimaTransferencia;
            }
            else if (eleccion == 6) {
                //funcion hipotecarse
                capitalPrestamo = hipoteca();
                balance = balance + capitalPrestamo;
                tiempoPrestamo = meses();
                cuota = cuota(tiempoPrestamo, capitalPrestamo, interes);
                tablaAmortización(capitalPrestamo, tiempoPrestamo, cuota, interes);
            }
            else if (eleccion == 7) {
                //funcion mi cuenta
                Micuenta(balance, ultimoDeposito, ultimaExtraccion, ultimaTransferencia, ibanEmisor, ibanreceptor, capitalPrestamo, tiempoPrestamo, cuota, interes, nombre, IBAN, correo, fechaNacimiento, DNI);
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
    public static long hipoteca(){
        long capital;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el capital que desearía: ");
        capital = entrada.nextLong();
        return capital;
    }
    public static long meses(){
        long meses;
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿A cuantos años quiere financiar el préstamo?: ");
        meses = entrada.nextLong();
        meses = meses*12;
        return meses;
    }
    public static double cuota(long meses, long capital, double interes){
        double cuota;
        double interesMes = interes/12;
        System.out.println("Con un capital de " + capital + "\u20AC, a un interés del "+ interes*100 +"%, a " + meses/12 + " años");

        cuota = capital * interesMes;
        cuota = cuota * Math.pow((1 + interesMes), meses);
        cuota = cuota / (Math.pow((1 + interesMes), meses) - 1);
        cuota = (double)Math.round(cuota*100)/100;
        System.out.println("Su cuota será de " + cuota);
        return cuota;
    }

    public static void tablaAmortización(long capital,long meses,double cuota,double interes){
        System.out.println("\t\t\tPAGO MENSUAL\tINTERESES\t\tAMORTIZADO\t\tCAPITAL VIVO\n");
        double Capital = (double) capital;
        double interesMensual = interes/12;

        double interesAbonadoAnterior = 0;
        double interesAbonado = 0;

        double capitalAmortizadoAnterior = 0;
        double capitalAmortizado = 0;

        double capitalVivoAnterior = 0;
        double capitalVivo = 0;
        for(int i = 0; i <= meses; ++i){


            if (i == 0){
                System.out.print(i);
                System.out.print("\t\t\t\t   0,00");
                System.out.print("\t\t\t  0,00");
                System.out.print("\t\t\t  0,00");
                System.out.printf("\t\t%012.2f", Capital);

                interesAbonadoAnterior = 0;
                capitalAmortizadoAnterior = 0;
                capitalVivoAnterior = Capital;
            }
            else{
                interesAbonado = (capitalVivoAnterior*interesMensual);
                capitalAmortizado = (cuota-interesAbonado);
                capitalVivo = capitalVivoAnterior - capitalAmortizado;

                System.out.print("\n" + i);
                System.out.printf("\t\t\t%011.2f", cuota);
                System.out.printf("\t\t%010.2f", interesAbonado);
                System.out.printf("\t\t%010.2f", capitalAmortizado);
                System.out.printf("\t\t%012.2f", capitalVivo);

                interesAbonadoAnterior = interesAbonado;
                capitalAmortizadoAnterior = capitalAmortizado;
                capitalVivoAnterior = capitalVivo;
            }
        }
        System.out.print("\n");
    }
    public static void Micuenta(long balance, long ultimoDeposito, long ultimaExtraccion, long ultimaTransferencia, String ibanEmisor, String ibanReceptor, long capitalPrestamo, long tiempoPrestamo,
                                double cuota, double interes, String nombre, String IBAN, String correo, String fechaNacimiento, String DNI){
        System.out.println("Los datos de su cuenta ahora mismo:");
        balance(balance);
        if (ultimoDeposito != 0){
            ultimoDeposito(ultimoDeposito);
        }
        if (ultimaExtraccion != 0){
            ultimaExtraccion(ultimaExtraccion);
        }
        if (ultimaTransferencia != 0){
            ultimaTransferencia(ultimaTransferencia, ibanEmisor, ibanReceptor);
        }
        if (capitalPrestamo != 0){
            prestamo(capitalPrestamo, tiempoPrestamo, cuota, interes);
        }
        if (nombre != "0" || IBAN != "0"){
            datosPersonales(nombre, DNI, fechaNacimiento, correo, IBAN);
        }
        System.out.println("\n");
    }
    private static void balance(long balance){
        System.out.println("Dinero actual: " + balance + "\u20AC");
    }
    private static void ultimoDeposito(long ultimoDeposito){
        System.out.println("Su último deposito fue de " + ultimoDeposito + "\u20AC");
    }
    private static void ultimaExtraccion(long ultimaExtraccion){
        System.out.println("Su última extracción fue de " + ultimaExtraccion + "\u20AC");
    }
    private static void ultimaTransferencia(long ultimaTransferencia, String ibanEmisor, String ibanReceptor){
        System.out.println("Su última transferencia fue de " + ultimaTransferencia + "\u20AC");
        System.out.println("De la cuenta " + ibanEmisor + " a la cuenta " + ibanReceptor);
    }
    private static void prestamo(long capitalPrestado, long tiempoPrestamo, double cuota, double interes){
        System.out.println("Ha adquirido un prestamo de " + capitalPrestado + "\u20AC");
        System.out.println("Durante " + tiempoPrestamo + " años");
        System.out.println("A un interés del " + interes*100 + "%");
        System.out.println("Con una cuota mensual de " + cuota + "\u20AC");
    }
    private static void datosPersonales(String nombre, String DNI, String fechaNacimiento, String correo, String IBAN){
        int dia, mes, año;
        char Dia, Mes, Año;
        Dia = fechaNacimiento.charAt(0);
        dia = Character.getNumericValue(Dia);
        Dia = fechaNacimiento.charAt(1);
        dia = (dia*10) + Character.getNumericValue(Dia);

        Mes = fechaNacimiento.charAt(2);
        mes = Character.getNumericValue(Mes);
        Mes = fechaNacimiento.charAt(3);
        mes = (mes*10) + Character.getNumericValue(Mes);

        Año = fechaNacimiento.charAt(4);
        año = Character.getNumericValue(Año);
        Año = fechaNacimiento.charAt(5);
        año = (año*10) + Character.getNumericValue(Año);

        System.out.println("nombre: " + nombre);
        System.out.println("DNI: " + DNI);
        System.out.println("Fecha de nacimiento: " + dia + "/" + mes + "/" + año);
        System.out.println("Correo: " + correo);
        System.out.println("Número de cuenta: " + IBAN);
    }
}
