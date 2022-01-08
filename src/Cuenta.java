public class Cuenta {

    //Este objeto funciona igual que la lista cliente, un objeto puede ser cuenta o lista de cuentas según como se utilice

    //Los atributos del objeto cuenta

    private Cuenta[] lista; //Para el objeto que será la lista de cuentas
    private int codigo; //El codigo que relaciona el cliente con sus cuentas
    private String IBAN; //El IBAN único de cada cuenta que lo relaciona con sus operaciones
    private double dinero; // El dinero que posee cada cuenta
    private Utilidades.TipoCuenta tipo;

    //Aquí estan las funciones para cada cliente especifico

    //Aqui las funciones setter

    public void setCuenta(int codigo, String IBAN, double dinero, Utilidades.TipoCuenta Tipo){
        this.codigo = codigo;
        this.IBAN = IBAN;
        this.dinero = dinero;
        this.tipo = Tipo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    public void setTipo(Utilidades.TipoCuenta tipo) {
        this.tipo = tipo;
    }
    //Las funciones getter para cada cliente especifico

    public int getCodigo() {
        return codigo;
    }
    public String getIBAN() {
        return IBAN;
    }
    public double getDinero() {
        return dinero;
    }
    public Cuenta[] getLista() {
        return lista;
    }
    public Utilidades.TipoCuenta getTipo() {
        return tipo;
    }
    public void showCuenta(){
        System.out.println(this.toString()+"{Tipo: "+ this.getTipo().toString()+" IBAN: "+this.getIBAN()+" Dinero: "+this.getDinero()+" Codigo: "+this.getCodigo()+"}");
    }//Esta funcion muestra la informacion de la cuenta

    //Aquí estan las funciones para cada cliente dentro de la lista con la posicion en la lista como parametro

    //Aqui las funciones setter para cada cliente de la lista

    public void setListaCuenta(int posicion, int codigo, String IBAN, double dinero, Utilidades.TipoCuenta tipo){
        this.lista[posicion-1].setCuenta(codigo, IBAN, dinero, tipo);
    }
    public void setListaCodigo(int posicion, int codigo){
        this.lista[posicion-1].setCodigo(codigo);
    }
    public void setListaIBAN(int posicion, String IBAN){
        this.lista[posicion-1].setIBAN(IBAN);
    }
    public void setListaDinero(int posicion, double dinero){
        this.lista[posicion-1].setDinero(dinero);
    }
    public void setListaTipo(int posicion, Utilidades.TipoCuenta Tipo){
        this.lista[posicion-1].setTipo(Tipo);
    }

    //Aqui las funciones getter para cada cliente

    public Cuenta getListaCuenta(int posicion){
        return this.lista[posicion-1];
    }
    public int getListaCodigo(int posicion){
        return this.lista[posicion-1].getCodigo();
    }
    public String getListaIBAN(int posicion){
        return this.lista[posicion-1].getIBAN();
    }
    public double getListaDinero(int posicion){
        return this.lista[posicion-1].getDinero();
    }
    public Utilidades.TipoCuenta getListaTipo(int posicion){
        return this.lista[posicion-1].getTipo();
    }
    public void showListaCuenta(int posicion){
        this.lista[posicion-1].showCuenta();
    }//Esta funcion muestra la informacion de la cuenta con la posicion de la cuenta en lista como parametro

    //Aqui estan las funciones de la cuenta que tengo que crear para poder usar el objeto como lista de cuentas

    public void createLista(){//Esta funcion define a funcion lista para el objeto que será lista de cuentas
        this.lista = new Cuenta[200];
    }
    public void createNewCuenta(int posicion){//Esta funcion crea un objeto cuenta en la posicion de la lista que se pasa como parametro
        this.lista[posicion-1] = new Cuenta();
    }
    public void showAllData(int inferior, int superior){//Esta funcion muestra el nombre y los atributos de todos los objetos de la lista
        for(int i=(inferior-1); i<superior; ++i){
            if (this.lista[i] != null) {
                this.lista[i].showCuenta();
            }
        }
    }
    public int findFreeSpace(){//Esta funcion encuentra un hueco libre en la lista de cuentas
        int n = 0;
        for (int i=0; i<200; ++i){
            if(this.lista[i] == null && n == 0){
                n = i +1;
            }
        }
        return n;
    }
    public int howManyCuentas(int codigo){//Esta funcion devuelve las cuentas que pertenecen a un cliente mediante el codigo del cliente
        int numCuentas = 0;
        for (int i=0; i<200; ++i){
            if(this.lista[i] != null) {
                if (this.lista[i].getCodigo() == codigo) {
                    numCuentas = numCuentas + 1;
                }
            }
        }
        return numCuentas;
    }
    public Cuenta[] getMyCuentas(int codigo){//Esta funcion devuelve una lista con todas las cuentas del cliente qu se mete por parametro (el codigo del cliente)
        Cuenta[] cuentas = new Cuenta[10];
        int contador = 0;
        for (int i=0; i<200; ++i){
            if(this.lista[i] != null) {
                if (this.lista[i].getCodigo() == codigo) {
                    cuentas[contador] = this.getListaCuenta(i + 1);
                    contador = contador + 1;
                }
            }
        }
        return cuentas;
    }
    public void updateLista(Cuenta[] listaaux){//Esta funcion recibe como parametro una lista con las cuentas y actualiza la informacion de la lsta general de cuenttas con las informacion del parametro
        for(int i=0; i<listaaux.length; ++i){
            if(listaaux[i] != null) {
                for(int j=0; j<200; ++j) {
                    if (this.lista[j] != null){
                        if(this.lista[j].getCodigo() == listaaux[i].getCodigo() && this.lista[j].getIBAN() == listaaux[i].getIBAN()){
                            this.lista[j] = listaaux[i];
                        }
                    }
                }
            }
        }
    }
    public boolean ibanInLista(String IBAN){//Esta funcion booleana te dice si ya existe este IBAN dentro de la lista de cuentas
        boolean enLista = false;
        for (int i=0; i<200; ++i){
            if(this.lista[i] != null){
                if(this.lista[i].getIBAN().equals(IBAN)){
                    enLista = true;
                }
            }
        }
        return enLista;
    }
    public int findPosicionIban(String IBAN){//Esta funcion devuelve la posicion de una cuenta dentro de la lista buscandola por su IBAN
        int posicion = 0;
        for (int i=0; i<200; ++i){
            if(this.lista[i] != null){
                if(this.lista[i].getIBAN().equals(IBAN)){
                    posicion = i + 1;
                }
            }
        }
        return posicion;
    }
}
