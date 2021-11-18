import java.util.Scanner;

public class Prestamo {
    //Aqui se hace el prestamo
    public static long hipoteca(){
        long capital;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el capital que desearía: ");
        capital = entrada.nextLong();
        return capital;
    }
    //Aquí se calculan los meses
    public static long meses(){
        long meses;
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿A cuantos años quiere financiar el préstamo?: ");
        meses = entrada.nextLong();
        meses = meses*12;
        return meses;
    }
    //Aquí se calcula la cuota
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
    //Aquí se presenta los datos del préstamo
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
}
