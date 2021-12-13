public class CodigoDesechado {
    public static boolean dni(String DNI){
        boolean correcto;
        String letra = Character.toString(DNI.charAt(8));
        String letralista;
        String[] letras = new String[] {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        int [] numdni = new int[8];
        int resultado = 0;
        int contador = 7;
        for (int i=0; i<=7; ++i){
            numdni[i] = Integer.parseInt(Character.toString(DNI.charAt(i)));
        }
        while(contador >= 0){
            if (contador == 0){
                resultado = resultado + (numdni[7-contador]);
            }
            else {
                resultado = resultado + (numdni[7 - contador] * (int) Math.pow(10, contador));
            }
            contador = contador - 1;
        }
        resultado = resultado%23;
        letralista = letras[resultado];
        if(letra.equals(letralista)){
            correcto = true;
        }
        else{
            correcto = false;
        }
        return correcto;
    }
    public static void main(String[] args) {
        System.out.println(dni("27335788K"));
    }
    /* Cliente Clientes = new Cliente();
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
