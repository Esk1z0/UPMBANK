public class funciones {
    public static boolean letraDNI(char a, long b){
        String cadena = "TRWAGMYFPDXBNJZSQVHLCKE";
        int d = (int)b%23;
        if (cadena.charAt(d) == a){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
