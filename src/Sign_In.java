import java.util.Scanner;

public class Sign_In {
    public static void numeros(){
        long CE = 9010;
        long CS = 0201;
        int a1, a2, a3, a4, b1, b2, b3, b4;

        String ce = String.valueOf(CE);
        a1 = Character.getNumericValue(ce.charAt(0));
        a2 = Character.getNumericValue(ce.charAt(1));
        a3 = Character.getNumericValue(ce.charAt(2));
        a4 = Character.getNumericValue(ce.charAt(3));
        System.out.println(ce);
        System.out.println(a2);
    }

    public static void main(String[] args) {
        numeros();
    }



}
