import java.util.Scanner;

public class Movimientos {
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
    //Este se ejecuta cuando seleccionan crear una nueva cuenta
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
    //Aquí se crea el Número de cuenta
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
    //Aquí se crea el número seguridad del numero de cuenta
    //El primer número
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
    //El segundo número
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

    //Esto se ejecuta cuando selecciona hacer un deposito
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

    //Esto se ejcuta cuando eliges hacer una retirada
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
}
