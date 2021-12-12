public class CodigoDesechado {
    public static void main(String[] args) {
        Cliente Clientes = new Cliente();
        int n = Integer.parseInt("02768876", 10);
        System.out.println(Clientes.isRightDni("K", n));
        System.out.println(2768876%23);
    }
    /* int n = 7;
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
