import java.util.Scanner;
public class Utilidades {
    private int dia;
    private int mes;
    private int año;

    public Utilidades(int dia, int mes, int año) {
        this.dia=dia;
        this.mes=mes;
        this.año=año;
    }
    public int getDia(){
        return dia;
    }
    public void setDia(int dia){
        this.dia = dia;
    }
    public int getMes(){
        return mes;
    }
    public void setMes(int mes){
        this.mes = mes;
    }
    public int getAño(){
        return año;
    }
    public void setAño(int año){
        this.año = año;
    }
    public void imprimir()
    {
        System.out.printf("%02d/%02d/%04d", dia, mes, año);
    }

    //Lo de arriba pues me obligan por eso de tener que tener la clase fecha, pero en verdad no lo uso

    enum TipoCuenta { AHORRO, REMUNERADA, CORRIENTE}

    //Metodos estaticos
    public static boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || año % 400 == 0;
    }
    public static boolean comprobarFecha(int dia, int mes, int año) {
        boolean fechaCorrecta = (año >= 1920 && año <= 2003 && mes >= 1 && mes <=12 && dia >= 1 && dia <= 31);
        if (fechaCorrecta){
            if (mes == 2)
                fechaCorrecta = dia <= 28 || (dia <= 29 && esBisiesto(año));
            else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
                fechaCorrecta = dia <= 30;
        }
        return fechaCorrecta;
    }
    public static boolean dni(String DNI){
        boolean correcto = false;
        try {
            String letra = Character.toString(DNI.charAt(8));
            String letralista;
            String[] letras = new String[]{"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
            int[] numdni = new int[8];
            int resultado = 0;
            int contador = 7;
            for (int i = 0; i <= 7; ++i) {
                numdni[i] = Integer.parseInt(Character.toString(DNI.charAt(i)));
            }
            while (contador >= 0) {
                if (contador == 0) {
                    resultado = resultado + (numdni[7 - contador]);
                } else {
                    resultado = resultado + (numdni[7 - contador] * (int) Math.pow(10, contador));
                }
                contador = contador - 1;
            }
            resultado = resultado % 23;
            letralista = letras[resultado];
            if (letra.equals(letralista)) {
                correcto = true;
            } else {
                correcto = false;
            }
        }
        catch (StringIndexOutOfBoundsException ex){
            correcto = false;
        }
        return correcto;
    }
    public static String createIBAN(String cs){
        String CE = "9010";
        String CS = cs;
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
    private static int c1(String CE, String CS){
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
    private static int c2(int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9, int d10) {
        int num, r, c;
        int c2 = 0;
        num = (d1) + (2 * d2) + (4 * d3) + (8 * d4) + (5 * d5) + (10 * d6) + (9 * d7) + (7 * d8) + (3 * d9) + (6 * d10);
        r = num % 11;
        c = 11 - r;
        if (c < 10) {
            c2 = c;
        } else if (c == 11) {
            c2 = 0;
        } else if (c == 10) {
            c2 = 1;
        }
        return c2;
    }
    public Cuenta[] deleteListaCuenta(Cuenta[] lista){
        Cuenta[] listaAux = new Cuenta[lista.length];
        for(int i=0; i<lista.length; ++i){
            lista[i] = listaAux[i];
        }
        return lista;
    }
    public static void askForDataCliente(int numCliente, Cliente Lista) {
        boolean continua = false;
        String nombre = "", apellidos = "";
        int diaNac = 0, mesNac = 0, añoNac = 0, codigo;
        String DNI = "";
        String correo = "a";
        Scanner entrada = new Scanner(System.in);
        while(!continua){
            System.out.println("Para crear una cuenta en UPMBank se le va a pedir una serie de datos");
            System.out.print("Nombre: ");
            nombre = entrada.nextLine();
            System.out.print("\nApellidos: ");
            apellidos = entrada.nextLine();
            do {
                System.out.print("\nDía de nacimiento (dd): ");
                diaNac = entrada.nextInt();
                System.out.print("\nMes de nacimiento (mm): ");
                mesNac = entrada.nextInt();
                System.out.print("\nAño de nacimiento (aaaa): ");
                añoNac = entrada.nextInt();
            } while (Utilidades.comprobarFecha(diaNac, mesNac, añoNac) != true);
            do {
                System.out.print("\nDeme los numeros del su DNI: ");
                DNI = entrada.next();

            } while (Utilidades.dni(DNI) != true);

            System.out.println("DNI Correcto");

            do {
                System.out.println("\nIntroduzca un correo válido de la UPM:");
                correo = entrada.next();
            } while (!correo.contains("@alumnos.upm.es") && !correo.contains("@upm.es"));
            if (Lista.isInLista(DNI, correo) == false){
                continua = true;
            }
            else{
                System.out.println("Lo sentimos pero ese DNI/Correo ya están registrado");
            }
        }
        codigo = Lista.createCodigo(numCliente);
        Lista.setListaCliente(numCliente, nombre, apellidos, Integer.toString(diaNac), Integer.toString(mesNac), Integer.toString(añoNac), DNI, codigo, correo);
        Lista.showListaCliente(numCliente);
        System.out.print("\nSu cuenta ya está regitrada. Felicidades\n");
    }
    public static int logInCliente(Cliente ListaClientes, Scanner entrada){
        String DNI;
        String correo;
        int contador = 0;
        int posicion = 0;
        do {
            System.out.print("\nIntroduzca su DNI: ");
            DNI = entrada.next();
            System.out.print("\nIntroduzca su correo de la UPM: ");
            correo = entrada.next();
            if (ListaClientes.findCliente(DNI, correo) == 0){
                System.out.println("Lo sentimos, habrá insertado mal los datos, vuelva a interntarlo.");
                contador = contador + 1;
            }
        }while(ListaClientes.findCliente(DNI, correo) == 0 && contador < 3);
        if(ListaClientes.findCliente(DNI, correo) != 0) {
            posicion = ListaClientes.findCliente(DNI, correo);
            System.out.println("Bienvenido " + ListaClientes.getListaNombre(posicion) + " " + ListaClientes.getListaApellidos(posicion) + " !");
        }
        else if (ListaClientes.findCliente(DNI, correo) == 0){
            System.out.println("Lo sentimos, demasiados intentos");
        }
        return posicion;
    }

    public static TipoCuenta tipoDeCuenta(Scanner entrada){
        int eleccion = 0;
        TipoCuenta tipo = null;
        do {
            System.out.print("\n1) Ahorro    2) Remunerada   3) Corriente\nQué tipo de cuenta desea: ");
            eleccion = entrada.nextInt();
            switch(eleccion){
                case 1:
                    tipo = TipoCuenta.AHORRO;
                    System.out.println("Cuenta AHORRO");
                    break;
                case 2:
                    tipo = TipoCuenta.REMUNERADA;
                    System.out.println("Cuenta REMUNERADA");
                    break;
                case 3:
                    tipo = TipoCuenta.CORRIENTE;
                    System.out.println("Cuenta CORRIENTE");
                    break;
            }
        }while(eleccion < 1 && eleccion > 3);
        return tipo;
    }

    public static String askForDataCuenta(Cuenta lista, Scanner entrada){
        int eleccion = 0;
        String IBAN = "";
        String CS = "0";

        do {
            System.out.print("\n¿En qué Campus se encuentra?");
            System.out.print("\n1) Campus Sur  2) Ciudad Universitaria  3) Madrid Ciudad  4) Campus Montegancedo\n: ");
            eleccion = entrada.nextInt();
            CS = TxtWriter.sucursalesReader(eleccion);
        }while(eleccion < 1 || eleccion > 4);
        do{
            IBAN = createIBAN(CS);
        }while(lista.ibanInLista(IBAN));
        return IBAN;
    }
    public static Operacion[] appendLista(Operacion[] lista, Operacion objeto){
        int tamaño = lista.length;
        int contador = lista.length;
        Operacion[] lista2 = new Operacion[tamaño+1];
        while(tamaño != 0){
            lista2[lista.length-contador] = lista[lista.length-contador];
            contador = contador - 1;
            tamaño = tamaño - 1;
        }
        lista2[lista2.length-1] = objeto;
        return lista2;
    }
    public static String logInClienteCuenta(Cliente ListaClientes, Cuenta ListaCuentas, Scanner entrada, int numCliente, int codigoCliente){
        boolean exists;
        String IBAN;
        int contador = 3;
        Cuenta[] MyCuenta;

        MyCuenta = ListaCuentas.getMyCuentas(codigoCliente);
        for(int i=0;i<MyCuenta.length; ++i){
            if(MyCuenta[i] != null) {
                System.out.println("Cuenta: " + MyCuenta[i].getIBAN() + " Dinero: " + MyCuenta[i].getDinero());
            }
        }
        do {
            System.out.println("Introduzca el IBAN de la cuenta con la que quiere realizar la operacion dinero: ");
            IBAN = entrada.next();
            String aux = IBAN;
            exists = ListaCuentas.ibanInLista(aux);
            if(!exists){
                System.out.println("Ups, habrá introducido mal el IBAN");
                contador = contador - 1;
            }
        }while(!exists && contador > 0);
        if(contador > 0 || exists) {
            System.out.println("Ha seleccionado la cuenta " + IBAN);
        }
        else if(contador == 0){
            IBAN = "";
        }
        return IBAN;
    }
    public static String ibanTransferencia(Cuenta ListaCuentas, Scanner entrada){
        String IBAN;
        boolean exists;
        int contador = 3;
        for(int i=1; i<201; ++i){
            if(ListaCuentas.getListaCuenta(i) != null){
                System.out.println(ListaCuentas.getListaIBAN(i));
            }
        }
        do {
            System.out.println("Introduzca el IBAN de la cuenta a la que quiere depositar dinero: ");
            IBAN = entrada.next();
            String aux = IBAN;
            exists = ListaCuentas.ibanInLista(aux);
            if(!exists){
                System.out.println("Ups, habrá introducido mal el IBAN");
                contador = contador - 1;
            }
        }while(!exists && contador > 0);
        if(contador > 0 || exists) {
            System.out.println("Ha seleccionado la cuenta " + IBAN);
        }
        else if(contador == 0){
            IBAN = "";
        }
        return IBAN;
    }
    public static double askMoney(Scanner entrada){
        System.out.println("Introduzca el importe en euros: ");
        double dinero = entrada.nextDouble();
        System.out.println("Importe: " + dinero + "\u20AC ");
        return dinero;
    }
    public static int mesesHipoteca(){
        int meses;
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿A cuantos años quiere financiar el préstamo?: ");
        meses = entrada.nextInt();
        meses = meses*12;
        return meses;
    }
    public static double calculateCuota(long meses, double capital, double interes){
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
    public static void showTablaAmortizacion(double capital,int meses,double cuota,double interes){
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


    public static void showMyData(Cliente clienteAux, Cuenta[] listaCuentas, Operacion ListaOperaciones){
        String Nombre = clienteAux.getNombre();
        String Apellidos = clienteAux.getApellidos();
        String FechaNac = clienteAux.getFechaDia() + "/" + clienteAux.getFechaMes() + "/" + clienteAux.getFechaAño();
        String Correo = clienteAux.getCorreo();
        String DNI = clienteAux.getDni();
        System.out.print("Nombre Cliente: " + Nombre + "\nApellidos Cliente: " + Apellidos +
                "\nFecha de Nacimiento: " + FechaNac + "\nCorreo: " + Correo + "\nDNI: " + DNI + "\n");
        for(int i = 0; i < listaCuentas.length; ++i){
            if (listaCuentas[i] != null) {
                Cuenta cuentaAux = listaCuentas[i];
                Operacion[] listaOp = ListaOperaciones.getAllOperacionCuenta(cuentaAux.getIBAN());
                Utilidades.showCuentaOperaciones(cuentaAux, listaOp);
            }
        }
    }
    public static void showCuentaOperaciones(Cuenta cuenta, Operacion[] lista){
        System.out.print("\nCuenta: " + cuenta.getIBAN() + "\nDinero: " + cuenta.getDinero() + "\n");
        for(int i=0; i < lista.length; ++i){
            if (lista[i].getTipo().equals("Hipoteca")){
                System.out.println(lista[i].getTipo() + "\t" + lista[i].getImporte() + "\t" + lista[i].getIbanReceptor());
            }
            else if (lista[i].getTipo().equals("Retirada")){
                System.out.println(lista[i].getTipo() + "\t-" + lista[i].getImporte());
            }
            else if (lista[i].getTipo().equals("Deposito")){
                System.out.println(lista[i].getTipo() + "\t+" + lista[i].getImporte());
            }
            else if (lista[i].getTipo().equals("Transferencia")){
                if (lista[i].getIbanCuenta() == cuenta.getIBAN()) {
                    System.out.println(lista[i].getTipo() + "\t-" + lista[i].getImporte() +
                            " Cuenta Emisora: " + lista[i].getIbanCuenta() + " Cuenta Receptora: " + lista[i].getIbanReceptor());
                }
                else if (lista[i].getIbanReceptor() == cuenta.getIBAN()) {
                    System.out.println(lista[i].getTipo() + "\t+" + lista[i].getImporte() +
                            " Cuenta Emisora: " + lista[i].getIbanCuenta() + " Cuenta Receptora: " + lista[i].getIbanReceptor());
                }
            }
        }
    }
    }