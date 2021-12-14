public class Operacion {
    private String tipo;
    private int importe;
    private String ibanCuenta;
    private String ibanReceptor;
    private int size;
    private Operacion siguiente;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setImporte(int importe) {
        this.importe = importe;
    }
    public void setIbanCuenta(String ibanCuenta) {
        this.ibanCuenta = ibanCuenta;
    }
    public void setIbanReceptor(String ibanReceptor) {
        this.ibanReceptor = ibanReceptor;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public String getTipo() {
        return tipo;
    }

    public int getImporte() {
        return importe;
    }


}
