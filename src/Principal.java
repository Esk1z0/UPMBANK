import java.util.Scanner;

public class Principal {

    public static void menu(){
        int balance = 0;
        String nombre, IBAN, correo, fechaNacimiento;
        Scanner entrada = new Scanner(System.in);
        int eleccion = 0;
        System.out.println("Bienvenido, ¿qué desea?");
        do{
            System.out.print(" Darse de Alta(1)  Crear una cuenta(2)  Depósito(3)  Extración(4)  \n Transferencia(5)  Hipotecarse(6)       Mi Cuenta(7) Salir(8)\n Salir(0)");
            eleccion = entrada.nextInt();
            if (eleccion == 1) {
                //funcion darse de alta
                nombre = Registro.registro();
            }
            else if (eleccion == 2) {
                //funcion crear cuenta
                IBAN = Cuentas.cuenta();
            }
            else if (eleccion == 3) {
                //funcion deposito
            }
            else if (eleccion == 4) {
                //funcion extraccion
            }
            else if (eleccion == 5) {
                //funcion transferencia
            }
            else if (eleccion == 6) {
                //funcion hipotecarse
            }
            else if (eleccion == 7) {
                //funcion mi cuenta
            }
            else if (eleccion == 8){
                break;
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
}
