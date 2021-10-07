import java.util.Scanner;

public class Sign_In {
    public static void main(String[] args) {

        String nombre, apellidos;
        String letraDNI;
        int tipoCuenta, fechaNac, diaNac, mesNac, añoNac, pruebaDNI;
        long IBAN, numDNI;

        //Aqui pedimos el nombre al maromo

        Scanner entrada = new Scanner(System.in);
        System.out.println("Para crear una cuenta en UPMBank se le va a pedir una serie de datos");
        System.out.print("Nombre: ");
        nombre = entrada.nextLine();
        System.out.print("\nApellidos: ");
        apellidos = entrada.nextLine();

        //Aquí pedimos la fecha de nacimiento

        System.out.print("\nDía de nacimiento (dd): ");
        diaNac = entrada.nextInt();
        System.out.print("\nMes de nacimiento (mm): ");
        mesNac = entrada.nextInt();
        System.out.print("\nAño de nacimiento (aa): ");
        añoNac = entrada.nextInt();
        System.out.printf("\nSu fecha de nacimiento es: %02d/%02d/%02d", diaNac, mesNac, añoNac);

        //Aquí pedimos el dni y comprobamos que es verdadera

        System.out.print("\nDeme los números de su DNI: ");
        numDNI = entrada.nextLong();
        if (numDNI > 99999999)
            System.out.println("Error, numero muy largo");
        else
            System.out.println("Número aceptado");
        System.out.print("\nAhora introduzca la letra de su DNI: ");
        letraDNI = entrada.next();
        pruebaDNI = (int)(numDNI % 23);
        switch (pruebaDNI){
            case 0:
                if (letraDNI == "T"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 1:
                if (letraDNI == "R"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 2:
                if (letraDNI == "W"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 3:
                if (letraDNI == "A"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 4:
                if (letraDNI == "G"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 5:
                if (letraDNI == "M"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 6:
                if (letraDNI == "Y"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 7:
                if (letraDNI == "F"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 8:
                if (letraDNI == "P"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 9:
                if (letraDNI == "D"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 10:
                if (letraDNI == "X"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 11:
                if (letraDNI == "B"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 12:
                if (letraDNI == "N"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 13:
                if (letraDNI == "J"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 14:
                if (letraDNI == "Z"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 15:
                if (letraDNI == "S"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 16:
                if (letraDNI == "Q"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 17:
                if (letraDNI == "V"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 18:
                if (letraDNI == "H"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 19:
                if (letraDNI == "L"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 20:
                if (letraDNI == "C"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 21:
                if (letraDNI == "K"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            case 22:
                if (letraDNI == "E"){
                    System.out.println("Su DNI es correcto: " + numDNI + letraDNI);
                }
                else {
                    System.out.println("Su DNI no es correcto");
                }
            default:

        }



    }
}
