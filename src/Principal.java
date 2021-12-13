import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        menu();
    }
    //Aquí está el menú y se ejecutan todas las funciones
    public static void menu(){
        Cliente ListaClientes = new Cliente();

        int numCliente;

        int eleccion = 0;
        long balance = 0, ultimoDeposito = 0, ultimaExtraccion = 0, ultimaTransferencia = 0;
        long capitalPrestamo = 0, tiempoPrestamo = 0;
        double cuota = 0, interes = 0.03;
        String nombre = "0", IBAN = "0", correo = "0", fechaNacimiento = "0",DNI = "0", DNIletra,ibanEmisor = "0", ibanreceptor = "0";
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bienvenido, ¿qué desea?");
        do{
            System.out.print(" Darse de Alta(1)  Crear una cuenta(2)  Depósito(3)  Extración(4)  \n Transferencia(5)  Hipotecarse(6)  Mi Cuenta(7) Salir(0)\n:");
            eleccion = entrada.nextInt();

            if (eleccion == 1) {
                //funcion darse de alta
                if (ListaClientes.isFull()){
                    ListaClientes.createNewCliente(9);
                }
                else{
                   numCliente = ListaClientes.findFreeSpace();
                   ListaClientes.createNewCliente(numCliente);
                   ListaClientes.askForData(numCliente);
                }
            }
            else if (eleccion == 2) {
                //funcion crear cuenta
                IBAN = Movimientos.cuenta();
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
                if (IBAN == "0"){
                    System.out.println("No tiene cuenta, lo sentimos mucho");
                }
                else if (IBAN != "0") {
                    capitalPrestamo = Prestamo.hipoteca();
                    balance = balance + capitalPrestamo;
                    tiempoPrestamo = Prestamo.meses();
                    cuota = Prestamo.cuota(tiempoPrestamo, capitalPrestamo, interes);
                    Prestamo.tablaAmortización(capitalPrestamo, tiempoPrestamo, cuota, interes);
                }
            }
            else if (eleccion == 7) {
                //funcion mi cuenta
                Miinfo.Micuenta(balance, ultimoDeposito, ultimaExtraccion, ultimaTransferencia, ibanEmisor, ibanreceptor, capitalPrestamo, tiempoPrestamo, cuota, interes, nombre, IBAN, correo, fechaNacimiento, DNI);
            }
            else if (eleccion == 0){
                System.out.println("Vuelva pronto");
            }
            else {
                System.out.println("Opción Inválida");
            }
        }while(eleccion != 0);
        ListaClientes.showAllData();
    }
}
