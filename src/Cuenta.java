public class Cuenta {
    private Cuenta[] lista = new Cuenta[200];
    private int codigo;
    private int Cuenta;
    private double dinero;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setCuenta(int cuenta) {
        Cuenta = cuenta;
    }
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    public int getCodigo() {
        return codigo;
    }
    public int getCuenta() {
        return Cuenta;
    }
    public double getDinero() {
        return dinero;
    }
}
