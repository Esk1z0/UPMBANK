public class Operacion {

    //Esta funcion no tiene lista, si no que enlaza todas las operaciones una detrás de otra

    //Aquí están los atributos

    private boolean cabeza; //Este indica cual es la operacion inicial qe seá usado como objeto con el que trabajar
    private String tipo; //Aqui se indica que tipo de operacion es
    private double importe; //Aquí se indica el dinero que se introduce o se extrae
    private String ibanCuenta; //Este es el IBAN que relaciona la operacion con la cuenta
    private String ibanReceptor;// Esta es la variable que funciona como el IBAN de reccion en la transferencia y los meses en la hipoteca
    private int size; //Este es el tamaño de la lista o la cantidad de operaciones
    private Operacion siguiente; // Este es el puntero a la siguiente operacion

    //Aqui estan las funciones para cada objeto operacion

    //Aqui estan las funciones setter para cada variable

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
    }//Es el constructor para el siguiente objeto
    public void setNextSiguinte(Operacion siguiente){
        this.siguiente = siguiente;
    }//Eso hace que el puntero siguiente apunte al objeto siguiente que metes como parametro
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
    }//Este es el contructor para la ultima operacion

    //Aqui estan las funciones getter de cada cliente

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
    public Operacion[] getAllOperacionTipo(String Tipo) {
        int tamaño = this.getSize();
        Operacion aux = this;
        Operacion[] listaAux2 = new Operacion[0];
        Operacion[] listaAux;
        while (tamaño > 0) {
            if (aux.getTipo() != null) {
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

    public Operacion[] getAllOperacionCuenta(String IbanCuenta){
        int tamaño = this.getSize();
        Operacion aux = this;
        Operacion[] listaAux2 = new Operacion[0];
        Operacion[] listaAux;
        while (tamaño > 0 ){
            if(aux.getIbanCuenta() != null) {
                if (aux.getIbanCuenta() == IbanCuenta) {
                    listaAux = Utilidades.appendLista(listaAux2, aux);
                    listaAux2 = listaAux;

                }
                else if (aux.getIbanReceptor() != null){
                    if(aux.getIbanReceptor() == IbanCuenta){
                        listaAux = Utilidades.appendLista(listaAux2, aux);
                        listaAux2 = listaAux;
                    }
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
