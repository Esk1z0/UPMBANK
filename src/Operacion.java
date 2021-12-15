public class Operacion {
    private boolean cabeza;
    private String tipo;
    private double importe;
    private String ibanCuenta;
    private String ibanReceptor;
    private int size;
    private Operacion siguiente;

    public void setThisOperacion(boolean cabeza, String tipo, double importe, String ibanCuenta, String ibanReceptor){
        this.cabeza = cabeza;
        this.tipo = tipo;
        this.importe = importe;
        this.ibanCuenta = ibanCuenta;
        this.ibanReceptor = ibanReceptor;
    }
    public void setCabeza(boolean cabeza) {
        this.cabeza = cabeza;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setImporte(double importe) {
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

    public void setSiguiente(boolean cabeza, String Tipo, int Importe, String IbanCuenta, String IbanReceptor) {
        this.setCabeza(cabeza);
        this.siguiente.setTipo(Tipo);
        this.siguiente.setImporte(Importe);
        this.siguiente.setIbanCuenta(IbanCuenta);
        this.siguiente.setIbanReceptor(IbanReceptor);
    }
    public void setNextSiguinte(Operacion siguiente){
        this.siguiente = siguiente;
    }
    public void setLastSiguiente(boolean cabeza, String tipo, double importe, String ibanCuenta, String ibanReceptor){
        int tamaño = this.getSize();
        Operacion aux = this;
        while(tamaño > 0){
            if(aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            tamaño = tamaño - 1;
        }
        aux.setThisOperacion(cabeza, tipo, importe, ibanCuenta, ibanReceptor);
    }

    public String getTipo() {
        return tipo;
    }
    public double getImporte() {
        return importe;
    }
    public String getIbanCuenta() {
        return ibanCuenta;
    }
    public String getIbanReceptor() {
        return ibanReceptor;
    }
    public int getSize() {
        return size;
    }
    public Operacion getSiguiente() {
        return siguiente;
    }

    public int createNewOperacion(int Size){
        int tamaño = Size;
        if(tamaño == 1){
            this.siguiente = new Operacion();
            this.siguiente.setCabeza(false);
            tamaño = 2;
        }
        else if (tamaño > 1){
            tamaño = this.siguiente.createNewOperacion(Size-1);
            tamaño = tamaño + 1;
        }
        return tamaño;
    }
    public Operacion[] getAllOperacionTipo(String Tipo){
        int tamaño = this.getSize();
        Operacion aux = this;
        Operacion[] listaAux2 = new Operacion[0];
        Operacion[] listaAux;
        while (tamaño > 0 ){
            if(aux.getTipo() != null) {
                if (aux.getTipo() == Tipo) {
                    listaAux = Utilidades.appendLista(listaAux2, aux);
                    listaAux2 = listaAux;

                }
            }
            if (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();

            }
            tamaño = tamaño - 1;
        }
        return listaAux2;
    }

}
