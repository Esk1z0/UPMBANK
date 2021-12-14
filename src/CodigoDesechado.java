public class CodigoDesechado {
    public static void main(String[] args) {
        int p;
        boolean m;

        Cliente ListaClientes = new Cliente();
        Cuenta ListaCuentas = new Cuenta();
        Cuenta[] lista = new Cuenta[10];
        ListaCuentas.createLista();
        ListaClientes.createLista();
        ListaClientes.createNewCliente(1);
        ListaClientes.createNewCliente(3);
        ListaClientes.setListaCliente(1,"Juan", "Juan", "11", "11", "2000", "02768876K", 1100, "juan@upm.es");
        ListaClientes.setListaCliente(3,"Juan", "Juan", "11", "11", "2000", "", 1300, "jua@upm.es");
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1100,"0000000000", 0.0);
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1300,"006565656565000", 100.0);
        p = ListaCuentas.findFreeSpace();
        ListaCuentas.createNewCuenta(p);
        ListaCuentas.setListaCuenta(p, 1300,"11111156565000", 2000.0);
        lista = ListaCuentas.getMyCuentas(1300);
        m = ListaCuentas.ibanInLista("0000000000");
        for(int i=0; i<lista.length; ++i){
            if(lista[i] != null) {
                lista[i].showCuenta();
            }
        }
        boolean n = ListaClientes.isInLista("02768876K", "d");
        System.out.println(n +"  "+ m);
    }
}
    /* Cuenta cuentas = new Cuenta();
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

