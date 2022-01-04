import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        menu();
    }
    //Aquí está el menú y se ejecutan todas las funciones
    public static void menu(){
        Cliente ListaClientes = new Cliente();
        Cuenta ListaCuentas = new Cuenta();
        Operacion ListaOperaciones = new Operacion();
        ListaClientes.createLista();
        ListaCuentas.createLista();
        ListaOperaciones.setSize(1);
        ListaOperaciones.setCabeza(true);
        int numCliente, numCuenta, codigoCliente;
        String IBAN = "0", IBANReceptor = "0";
        int eleccion = 0;
        double dinero, interes = 0.03, cuota = 0;

        long balance = 0, ultimoDeposito = 0, ultimaExtraccion = 0, ultimaTransferencia = 0;
        long capitalPrestamo = 0, tiempoPrestamo = 0;
        String nombre = "0", correo = "0", fechaNacimiento = "0",DNI = "0", DNIletra,ibanEmisor = "0", ibanreceptor = "0";
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bienvenido, ¿qué desea?");
        do{
            System.out.print(" Darse de Alta(1)  Crear una cuenta(2)  Depósito(3)  Extración(4)  \n Transferencia(5)  Hipotecarse(6)  Mi Cuenta(7) Salir(0)\n:");
            eleccion = entrada.nextInt();

            if (eleccion == 1) {
                //funcion darse de alta
                if (ListaClientes.isFull()){
                    ListaClientes.createNewCliente(1);
                    Utilidades.askForDataCliente(1, ListaClientes);
                }
                else{
                   numCliente = ListaClientes.findFreeSpace();
                   ListaClientes.createNewCliente(numCliente);
                   Utilidades.askForDataCliente(numCliente, ListaClientes);
                }
            }
            else if (eleccion == 2) {
                //funcion crear cuenta
                numCliente = Utilidades.logInCliente(ListaClientes, entrada);
                if(numCliente != 0 && ListaCuentas.howManyCuentas(ListaClientes.getListaCodigo(numCliente)) < 10){
                    IBAN = Utilidades.askForDataCuenta(ListaCuentas, entrada);
                    int espacio = ListaCuentas.findFreeSpace();
                    ListaCuentas.createNewCuenta(espacio);
                    ListaCuentas.setListaCuenta(espacio , ListaClientes.getListaCodigo(numCliente), IBAN, 0.0);
                    ListaCuentas.showListaCuenta(espacio);
                    System.out.println("Gracias por crear su nueva cuenta");
                }
                if (ListaCuentas.howManyCuentas(ListaClientes.getListaCodigo(numCliente)) == 10){
                    System.out.println("Ha alcanzado su límite de cuentas");
                }
            }
            else if (eleccion == 3) {
                //funcion deposito
                numCliente = Utilidades.logInCliente(ListaClientes, entrada);
                codigoCliente = ListaClientes.getListaCodigo(numCliente);
                IBAN = Utilidades.logInClienteCuenta(ListaClientes, ListaCuentas, entrada, numCliente, codigoCliente);
                if(IBAN != "") {
                    dinero = Utilidades.askMoney(entrada);
                    int newSize = ListaOperaciones.createNewOperacion(ListaOperaciones.getSize());
                    ListaOperaciones.setSize(newSize);
                    ListaOperaciones.setLastSiguiente(false, "Deposito", dinero, IBAN, "");
                    int posicion = ListaCuentas.findPosicionIban(IBAN);
                    ListaCuentas.setListaDinero(posicion, ListaCuentas.getListaDinero(posicion) + dinero);
                    ListaCuentas.showListaCuenta(posicion);
                }
            }
            else if (eleccion == 4) {
                //funcion extraccion
                numCliente = Utilidades.logInCliente(ListaClientes, entrada);
                codigoCliente = ListaClientes.getListaCodigo(numCliente);
                IBAN = Utilidades.logInClienteCuenta(ListaClientes, ListaCuentas, entrada, numCliente, codigoCliente);
                if(IBAN != "") {
                    dinero = Utilidades.askMoney(entrada);
                    int newSize = ListaOperaciones.createNewOperacion(ListaOperaciones.getSize());
                    ListaOperaciones.setSize(newSize);
                    ListaOperaciones.setLastSiguiente(false, "Retirada", 0 - dinero, IBAN, "");
                    int posicion = ListaCuentas.findPosicionIban(IBAN);
                    ListaCuentas.setListaDinero(posicion, ListaCuentas.getListaDinero(posicion) - dinero);
                    ListaCuentas.showListaCuenta(posicion);
                }
            }
            else if (eleccion == 5) {
                //funcion transferencia
                numCliente = Utilidades.logInCliente(ListaClientes, entrada);
                codigoCliente = ListaClientes.getListaCodigo(numCliente);
                IBAN = Utilidades.logInClienteCuenta(ListaClientes, ListaCuentas, entrada, numCliente, codigoCliente);
                IBANReceptor = Utilidades.ibanTransferencia(ListaCuentas, entrada);
                if(IBAN != "" && IBANReceptor != "") {
                    dinero = Utilidades.askMoney(entrada);
                    int newSize = ListaOperaciones.createNewOperacion(ListaOperaciones.getSize());
                    ListaOperaciones.setSize(newSize);
                    ListaOperaciones.setLastSiguiente(false, "Transferencia", dinero, IBAN, IBANReceptor);
                    int posicion = ListaCuentas.findPosicionIban(IBAN);
                    ListaCuentas.setListaDinero(posicion, ListaCuentas.getListaDinero(posicion) - dinero);
                    ListaCuentas.showListaCuenta(posicion);

                    posicion = ListaCuentas.findPosicionIban(IBANReceptor);
                    ListaCuentas.setListaDinero(posicion, ListaCuentas.getListaDinero(posicion) + dinero);
                    ListaCuentas.showListaCuenta(posicion);
                }
            }
            else if (eleccion == 6) {
                //funcion hipotecarse
                numCliente = Utilidades.logInCliente(ListaClientes, entrada);
                codigoCliente = ListaClientes.getListaCodigo(numCliente);
                IBAN = Utilidades.logInClienteCuenta(ListaClientes, ListaCuentas, entrada, numCliente, codigoCliente);
                if(IBAN != "") {
                    dinero = Utilidades.askMoney(entrada);
                    int meses = Utilidades.mesesHipoteca();
                    String Meses = Integer.toString(meses);
                    int newSize = ListaOperaciones.createNewOperacion(ListaOperaciones.getSize());
                    ListaOperaciones.setSize(newSize);
                    ListaOperaciones.setLastSiguiente(false, "Hipoteca", dinero, IBAN, Meses);
                    int posicion = ListaCuentas.findPosicionIban(IBAN);
                    ListaCuentas.setListaDinero(posicion, ListaCuentas.getListaDinero(posicion) + dinero);
                    cuota = Utilidades.calculateCuota(meses, dinero, interes);
                    Utilidades.showTablaAmortizacion(dinero, meses, cuota, interes);
                    ListaCuentas.showListaCuenta(posicion);
                }
            }
            else if (eleccion == 7) {
                //funcion mi cuenta(No esta echa)
                int posicion = Utilidades.logInCliente(ListaClientes, entrada);
                Cliente clienteAux = ListaClientes.getListaCliente(posicion);
                int codigo = ListaClientes.getListaCodigo(posicion);
                Cuenta[] listaAux = ListaCuentas.getMyCuentas(codigo);
                Utilidades.showMyData(clienteAux, listaAux, ListaOperaciones);
            }
            else if (eleccion == 0){
                System.out.println("Vuelva pronto");
            }
            else {
                System.out.println("Opción Inválida");
            }
        }while(eleccion != 0);
        ListaClientes.showAllData();
        ListaCuentas.showAllData(1,200);
    }
}
