import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TxtWriter {
    public static void matrizTransferencia(Cuenta[] listaCuentas, Operacion listaOperaciones){
        String[] cuentas = extractCuenta(listaOperaciones);
        Operacion[] listaTransferencias = listaOperaciones.getAllOperacionTipo("Transferencia");
        try{
            FileWriter out = new FileWriter("src\\Files\\fichero.txt");
            out.write("                      ");
            for (int i = 0; i < cuentas.length; ++i){
                out.write(cuentas[i]);
                out.write(" ");
            }
            out.write("\n");
            for(int i = 0; i < cuentas.length; ++i){
                out.write(cuentas[i]);
                for(int j = 0; j < cuentas.length; ++j){
                    double dinero = getAmount(cuentas[j], cuentas[i], listaTransferencias);
                    out.write("   "+ dinero + "               ");
                }
                out.write("\n");
            }

            out.close();
        }
        catch(IOException ex){
            System.out.println("Ups, ha habido un problema con la matriz de transferencias");
        }
    }
    public static String[] extractCuenta(Operacion listaOperaciones){
        Operacion[] listaTransferencias = listaOperaciones.getAllOperacionTipo("Transferencia");
        String cuentaAux = "";
        String[] listaCuentas = null;
        String[] lista1 = new String[1];
        int contador = 0;
        for (int i = 0; i < listaTransferencias.length; ++i){
            cuentaAux = listaTransferencias[i].getIbanCuenta();
            if(listaCuentas != null) {
                for (int j = 0; j < listaCuentas.length; ++j) {
                    if (cuentaAux == listaCuentas[j]) {
                        contador = contador + 1;
                    }
                }
                if (contador == 0) {
                    listaCuentas = appendStringList(listaCuentas, cuentaAux);
                } else {
                    contador = 0;
                }
            }
            else{
                lista1[0] = cuentaAux;
                listaCuentas = lista1;
            }
        }
        for (int i = 0; i < listaTransferencias.length; ++i){
            cuentaAux = listaTransferencias[i].getIbanReceptor();
            if(listaCuentas != null) {
                for (int j = 0; j < listaCuentas.length; ++j) {
                    if (cuentaAux == listaCuentas[j]) {
                        contador = contador + 1;
                    }
                }
                if (contador == 0) {
                    listaCuentas = appendStringList(listaCuentas, cuentaAux);
                } else {
                    contador = 0;
                }
            }
            else{
                lista1[0] = cuentaAux;
                listaCuentas = lista1;
            }
        }

        return listaCuentas;
    }
    public static String[] appendStringList(String[] lista, String objeto){
        int tamaño = lista.length;
        int contador = lista.length;
        String[] lista2 = new String[tamaño+1];
        while(tamaño != 0){
            lista2[lista.length-contador] = lista[lista.length-contador];
            contador = contador - 1;
            tamaño = tamaño - 1;
        }
        lista2[lista2.length-1] = objeto;
        return lista2;
    }
    public static Double getAmount(String IbanEmisor, String IbanReceptor,Operacion[] transferencias){
        double cantidad = 0;
        for(int i = 0; i < transferencias.length; ++i){
            if(transferencias[i] != null){
                if(transferencias[i].getIbanCuenta() == IbanEmisor && transferencias[i].getIbanReceptor() == IbanReceptor){
                    cantidad = cantidad + transferencias[i].getImporte();
                }
            }
        }
        return cantidad;
    }
}
