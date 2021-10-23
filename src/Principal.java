import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido, ¿qué desea?");
        while (true) {
            System.out.print(" Darse de Alta(1)  Crear una cuenta(2)  Depósito(3)  Extración(4)  \n Transferencia(5)  Hipotecarse(6)       Mi Cuenta(7) Salir(8)\n");
            int eleccion = entrada.nextInt();
            if (eleccion == 1) {
                //funcion darse de alta
                Registro.registro();
            }
            else if (eleccion == 2) {
                //funcion crear cuenta
                Cuentas.cuenta();
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
            else {
                System.out.println("Opción Inválida");
            }
        }
    }
}
