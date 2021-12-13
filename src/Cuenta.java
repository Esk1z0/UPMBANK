public class Cuenta {
    private Cuenta[] lista;
    private int codigo;
    private String IBAN;
    private double dinero;

    //para cada cuenta
    public void setCuenta(int codigo, String IBAN, double dinero){
        this.codigo = codigo;
        this.IBAN = IBAN;
        this.dinero = dinero;
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
    public int getCodigo() {
        return codigo;
    }
    public String getIBAN() {
        return IBAN;
    }
    public double getDinero() {
        return dinero;
    }
    public void showCuenta(){
        System.out.println(this.toString()+"{IBAN: "+this.getIBAN()+" Dinero: "+this.getDinero()+" Codigo: "+this.getCodigo()+"}");
    }

    //para la lista
    public void setListaCuenta(int posicion, int codigo, String IBAN, double dinero){
        this.lista[posicion-1].setCuenta(codigo, IBAN, dinero);
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
    public void showListaCuenta(int posicion){
        this.lista[posicion-1].showCuenta();
    }

    public void createLista(){
        this.lista = new Cuenta[200];
    }
    public void createNewCuenta(int posicion){
        this.lista[posicion-1] = new Cuenta();
    }
    public void showAllData(int inferior, int superior){
        for(int i=(inferior-1); i<superior; ++i){
            if (this.lista[i] != null) {
                this.lista[i].showCuenta();
            }
        }
    }
    public int findFreeSpace(){
        int n = 0;
        for (int i=0; i<200; ++i){
            if(this.lista[i] == null && n == 0){
                n = i +1;
            }
        }
        return n;
    }
    public int howManyCuentas(int codigo){
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
    public Cuenta[] getMyCuentas(int codigo){
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
    public void updateLista(Cuenta[] listaaux){
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
}
