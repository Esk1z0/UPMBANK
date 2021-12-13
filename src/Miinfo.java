public class Miinfo {
    //Aquí te muestra los datos de tu cuenta
    //El resto de funciones muestran los datos si hay datos, en caso contrario solo muestra los datos que están introducidos
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
    public static void balance(long balance){
        System.out.println("Dinero actual: " + balance + "\u20AC");
    }
    public static void ultimoDeposito(long ultimoDeposito){
        System.out.println("Su último deposito fue de " + ultimoDeposito + "\u20AC");
    }
    public static void ultimaExtraccion(long ultimaExtraccion){
        System.out.println("Su última extracción fue de " + ultimaExtraccion + "\u20AC");
    }
    public static void ultimaTransferencia(long ultimaTransferencia, String ibanEmisor, String ibanReceptor){
        System.out.println("Su última transferencia fue de " + ultimaTransferencia + "\u20AC");
        System.out.println("De la cuenta " + ibanEmisor + " a la cuenta " + ibanReceptor);
    }
    public static void prestamo(long capitalPrestado, long tiempoPrestamo, double cuota, double interes){
        System.out.println("Ha adquirido un prestamo de " + capitalPrestado + "\u20AC");
        System.out.println("Durante " + tiempoPrestamo + " años");
        System.out.println("A un interés del " + interes*100 + "%");
        System.out.println("Con una cuota mensual de " + cuota + "\u20AC");
    }
    public static void datosPersonales(String nombre, String DNI, String fechaNacimiento, String correo, String IBAN){
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
