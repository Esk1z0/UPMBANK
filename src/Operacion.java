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
    public void createNewOperacion(){
        this.siguiente = new Operacion();
    }
    /* Me voy a dormir, voy por aqu;i juanes del futuro*/
    public void setSiguiente(String Tipo, int Importe, String IbanCuenta, String IbanReceptor) {
        this.siguiente.setTipo(Tipo);
        this.siguiente.setImporte(Importe);
        this.siguiente.setIbanCuenta(IbanCuenta);
        this.siguiente.setIbanReceptor(IbanReceptor);
    }

    public String getTipo() {
        return tipo;
    }
    public int getImporte() {
        return importe;
    }
    public String getIbanCuenta() {
        return ibanCuenta;
    }
    public String getIbanReceptor() {
        return ibanReceptor;
    }
    public Operacion getSiguiente() {
        return siguiente;
    }

}
