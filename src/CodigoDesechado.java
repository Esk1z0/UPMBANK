import java.util.Scanner;

public class CodigoDesechado {
    public static void main(String[] args) {
        prueba6();
    }
    public static void prueba1(){
        Operacion primero = new Operacion();
        Operacion segundo = new Operacion();
        Operacion tercero = new Operacion();
        primero.setThisOperacion(true, "Cabeza", 0.0, "","");
        segundo.setThisOperacion(false, "Deposito", 23.0, "","");
        tercero.setThisOperacion(false, "Deposito", 0.0, "","");
        segundo.setNextSiguinte(tercero);
        primero.setNextSiguinte(segundo);
        primero.setSize(3);
        int Size = primero.createNewOperacion(primero.getSize());
        primero.setLastSiguiente(false, "Deposito", -2.2, "","");
        primero.setSize(Size);
        System.out.println(primero.getSize());
        Operacion[] lista = primero.getAllOperacionTipo("Deposito");
        for(int i=0; i< lista.length; ++i){
            System.out.println(lista[i]);
        }
    }
    public static void prueba2(){
        Operacion primero = new Operacion();
        Operacion segundo = new Operacion();
        Operacion tercero = new Operacion();
        Operacion cuarto = new Operacion();
        Operacion cinco = new Operacion();

        primero.setThisOperacion(true, "Cabeza", 0.0, "","");
        segundo.setThisOperacion(true, "Deposito", 23.0, "","");
        tercero.setThisOperacion(true, "Deposito", 0.0, "","");
        cuarto.setThisOperacion(true, "Transferencia", 0.0, "","");
        cinco.setThisOperacion(true, "Deposito", 0.0, "","");
        primero.setSize(5);
        cuarto.setNextSiguinte(cinco);
        tercero.setNextSiguinte(cuarto);
        segundo.setNextSiguinte(tercero);
        primero.setNextSiguinte(segundo);
        Operacion[] lista = new Operacion[] {primero, segundo};
        Operacion[] lista2 = Utilidades.appendLista(lista, tercero);
        Operacion[] lista3 = primero.getAllOperacionTipo("Deposito");
        for(int i=0; i< lista3.length; ++i){
            System.out.println(lista3[i]);
        }
        System.out.println("Operaciones: " + primero + "  " + segundo + "  " + tercero + "  " + cuarto + "  " + cinco);
    }

    public static void prueba3() {
        String k;
        int p;
        boolean m;
        Scanner entrada = new Scanner(System.in);

        Cliente ListaClientes = new Cliente();
        Cuenta ListaCuentas = new Cuenta();
        Cuenta[] lista = new Cuenta[10];
        ListaCuentas.createLista();
        ListaClientes.createLista();

        ListaClientes.createNewCliente(1);
        ListaClientes.createNewCliente(3);
        ListaClientes.setListaCliente(1, "Juan", "Juan", "11", "11", "2000", "02768876K", 1100, "juan@upm.es");
        ListaClientes.setListaCliente(3, "Juan", "Juan", "11", "11", "2000", "", 1300, "jua@upm.es");
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1100, "0000000000", 0.0);
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1300, "006565656565000", 100.0);
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1300, "11111156565000", 2000.0);

        lista = ListaCuentas.getMyCuentas(1300);
        m = ListaCuentas.ibanInLista("0000000000");
        for (int i = 0; i < lista.length; ++i) {
            if (lista[i] != null) {
                lista[i].showCuenta();
            }
        }
        boolean n = ListaClientes.isInLista("02768876K", "d");
        System.out.println(n + "  " + m);
    }

    public static void prueba4(){
        String k;
        int p, numCliente, codigoCliente;
        boolean m;
        Scanner entrada = new Scanner(System.in);

        Cliente ListaClientes = new Cliente();
        Cuenta ListaCuentas = new Cuenta();
        Cuenta[] lista = new Cuenta[10];
        ListaCuentas.createLista();
        ListaClientes.createLista();

        ListaClientes.createNewCliente(1);
        ListaClientes.createNewCliente(3);
        ListaClientes.setListaCliente(1, "Juan", "Juan", "11", "11", "2000", "02768876K", 1100, "juan@upm.es");
        ListaClientes.setListaCliente(3, "Juan", "Juan", "11", "11", "2000", "", 1300, "jua@upm.es");
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1100, "0000000000", 0.0);
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1100, "006565656565000", 100.0);
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1300, "11111156565000", 2000.0);

        //String IBAN = entrada.next();

        //System.out.println(ListaCuentas.ibanInLista(IBAN));
        numCliente = Utilidades.logInCliente(ListaClientes, entrada);
        codigoCliente = ListaClientes.getListaCodigo(numCliente);
        String IBAN = Utilidades.logInClienteCuenta(ListaClientes, ListaCuentas, entrada, numCliente, codigoCliente);

    }
    public static void prueba5(){
        Prestamo.hipoteca();
    }
    public static void prueba6(){
        String k;
        int p;
        boolean m;
        Scanner entrada = new Scanner(System.in);

        Cliente ListaClientes = new Cliente();
        Cuenta ListaCuentas = new Cuenta();
        Cuenta[] lista = new Cuenta[10];
        ListaCuentas.createLista();
        ListaClientes.createLista();
        Operacion primero = new Operacion();
        Operacion segundo = new Operacion();
        Operacion tercero = new Operacion();
        Operacion cuarto = new Operacion();
        Operacion cinco = new Operacion();

        ListaClientes.createNewCliente(1);
        ListaClientes.createNewCliente(3);
        ListaClientes.setListaCliente(1, "Juan", "Juan", "11", "11", "2000", "02768876K", 1100, "juan@upm.es");
        ListaClientes.setListaCliente(3, "Juan", "Juan", "11", "11", "2000", "", 1300, "jua@upm.es");
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1100, "0000000000", 0.0);
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1300, "006565656565000", 100.0);
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1100, "11111156565000", 2000.0);


        primero.setThisOperacion(true, "Cabeza", 0.0, "","");
        segundo.setThisOperacion(true, "Retirada", 23.0, "0000000000","");
        tercero.setThisOperacion(true, "Deposito", 10.0, "0000000000","");
        cuarto.setThisOperacion(true, "Transferencia", 20.0, "11111156565000","0000000000");
        cinco.setThisOperacion(true, "Deposito", 0.0, "0000000000","");
        primero.setSize(5);
        cuarto.setNextSiguinte(cinco);
        tercero.setNextSiguinte(cuarto);
        segundo.setNextSiguinte(tercero);
        primero.setNextSiguinte(segundo);

        Cuenta[] listacu = ListaCuentas.getMyCuentas(1100);
        Utilidades.showMyData(ListaClientes.getListaCliente(1), listacu, primero);
    }
        /*
        int num = Utilidades.logInCliente(ListaClientes, entrada);
        if(num != 0) {
            ListaClientes.showListaCliente(num);
        }

        k = Utilidades.askForDataCuenta(ListaCuentas, entrada);
                System.out.println(k);

                private static String getCS(){
        Scanner entrada = new Scanner(System.in);
        String CS = "0";
        int eleccion;
        do {
            System.out.print("\n¿En qué Campus se encuentra?");
            System.out.print("\n1) Campus Sur  2) Campus Montegancedo  3) Campus Madrid Ciudad  4) Campus Ciudad Universitaria");
            eleccion = entrada.nextInt();
            if (eleccion == 1) {
                CS = "0201";
            } else if (eleccion == 2) {
                CS = "0204";
            } else if (eleccion == 3) {
                CS = "0203";
            } else if (eleccion == 4) {
                CS = "0202";
            } else{
                System.out.println("Esa opcion no está disponible");
            }
        }while(eleccion < 1 || eleccion > 4);
        return CS;
    }

        Cuenta cuentas = new Cuenta();
        cuentas.createLista();
        cuentas.createNewCuenta(1);
        cuentas.createNewCuenta(100);
        cuentas.setListaCuenta(1, 2000, "1", 0.0);
        cuentas.setListaCuenta(100, 2000, "111111", 111.0);
        int f = cuentas.howManyCuentas(2000);
        cuentas.showAllData(1,110);
        int n = cuentas.findFreeSpace();
        Cuenta[] lista = cuentas.getMyCuentas(2000);
        System.out.println("Cuantas cuentas: "+f+" Espacio Vacío: "+n);
        for(int i=0; i<lista.length; ++i){
            if(lista[i] != null) {
                lista[i].showCuenta();
            }
        }


        Cliente Clientes = new Cliente();
        Clientes.createNewCliente(2);
        Clientes.setListaCliente(2, "f", "f","11","12", "2000","00", 0, "s@upm.es");
        Clientes.createNewCliente(1);
        Clientes.setListaCliente(1, "f", "f","11","12", "2000","00", 0, "s@upm.es");
        Clientes.createNewCliente(3);
        Clientes.setListaCliente(3, "f", "f","11","12", "2000","00", 0, "s@upm.es");
        int contadro = Clientes.findFreeSpace();
        System.out.println(contadro);
        int n = 7;
        int numero = 0;
        boolean correcto = false;
        char letra = dni.charAt(8);
        String[] letras = new String[] {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        for (int i=0 ; i<=7; ++i){
            numero += dni.charAt(i) * Math.pow(10, n);
            n = n-1;
        }
        if(letras[(numero%23)-1] == Character.toString(letra)){
            correcto = true;
        }
        return correcto;*/
}