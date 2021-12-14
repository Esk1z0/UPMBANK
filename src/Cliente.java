import java.util.Scanner;

public class Cliente {
    private Cliente[] lista;
    private String nombre;
    private String apellidos;
    private String fechaDia;
    private String fechaMes;
    private String fechaAño;
    private String dni;
    private String correo;
    private int codigo;

    //Funciones para cada cliente

    public void setCliente(String nombre, String apellidos, String fechaDia, String fechaMes, String fechaAño, String dni, int codigo, String correo){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaDia = fechaDia;
        this.fechaMes = fechaMes;
        this.fechaAño = fechaAño;
        this.dni = dni;
        this.codigo = codigo;
        this.correo = correo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setFechaDia(String fechaDia) {
        this.fechaDia = fechaDia;
    }
    public void setFechaMes(String fechaMes) {
        this.fechaMes = fechaMes;
    }
    public void setFechaAño(String fechaAño) {
        this.fechaAño = fechaAño;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getFechaDia() {
        return fechaDia;
    }
    public String getFechaMes() {
        return fechaMes;
    }
    public String getFechaAño() {
        return fechaAño;
    }
    public String getDni() {
        return dni;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getCorreo() {
        return correo;
    }
    public void showCliente(){
        System.out.println(this.toString()+"{Nombre: "+this.getNombre()+" Apellidos: "+this.getApellidos()+
                " Fecha de nacimiento: "+this.getFechaDia()+"/"+this.getFechaMes()+"/"+this.getFechaAño()+
                " DNI: "+this.getDni()+" Codigo: "+this.getCodigo()+" Correo: "+this.getCorreo()+" }");
    }

    //Funciones para los objetos de cada lista

    public void setListaCliente(int posicion,String nombre, String apellidos, String fechaDia, String fechaMes, String fechaAño, String dni, int codigo, String correo){

        this.lista[posicion-1].setCliente(nombre, apellidos, fechaDia, fechaMes, fechaAño, dni, codigo, correo);
    }
    public void setListaNombre(int posicion, String nombre) {
        this.lista[posicion-1].setNombre(nombre);
    }
    public void setListaApellidos(int posicion, String apellidos) {
        this.lista[posicion-1].setApellidos(apellidos);
    }
    public void setListaFechaDia(int posicion, String fechaDia) {
        this.lista[posicion-1].setFechaDia(fechaDia);
    }
    public void setListaFechaMes(int posicion, String fechaMes) {
        this.lista[posicion-1].setFechaMes(fechaMes);
    }
    public void setListaFechaAño(int posicion, String fechaAño) {
        this.lista[posicion-1].setFechaAño(fechaAño);
    }
    public void setListaDni(int posicion, String dni) {
        this.lista[posicion-1].setDni(dni);
    }
    public void setListaCodigo(int posicion, int codigo) {
        this.lista[posicion-1].setCodigo(codigo);
    }
    public void setListaCorreo(int posicion, String correo) {
        this.lista[posicion-1].setCorreo(correo);
    }
    public String getListaNombre(int posicion) {
        return this.lista[posicion-1].getNombre();
    }
    public String getListaApellidos(int posicion) {
        return this.lista[posicion-1].getApellidos();
    }
    public String getListaFechaDia(int posicion) {
        return this.lista[posicion-1].getFechaDia();
    }
    public String getListaFechaMes(int posicion) {
        return this.lista[posicion-1].getFechaMes();
    }
    public String getListaFechaAño(int posicion) {
        return this.lista[posicion-1].getFechaAño();
    }
    public String getListaDni(int posicion) {
        return this.lista[posicion-1].getDni();
    }
    public int getListaCodigo(int posicion) {
        return this.lista[posicion-1].getCodigo();
    }
    public String getListaCorreo(int posicion) {
        return this.lista[posicion-1].getCorreo();
    }
    public void showListaCliente(int posicion){
        this.lista[posicion-1].showCliente();
    }

    public void createLista(){
        this.lista = new Cliente[20];
    }
    public void createNewCliente(int posicion){
        this.lista[posicion-1] = new Cliente();
    }
    public void showLista(){
        for(int i=0; i<20; ++i){
            System.out.println(this.lista[i]);
        }
    }
    public void showAllData(){
        for(int i=0; i<20; ++i){
            if (this.lista[i] != null) {
                this.lista[i].showCliente();
            }
        }
    }
    public int findFreeSpace(){
        int n = 0;
        for (int i=0; i<20; ++i){
            if(this.lista[i] == null && n == 0){
                n = i +1;
            }
        }
        return n;
    }
    public int findCliente(String dni, String Correo){
        int posicion = 0;
        for (int i=0; i<20; ++i){
            if (this.lista[i] != null && this.lista[i].getDni() != null && this.lista[i].getCorreo() != null){
                if(this.lista[i].getDni().equals(dni) && this.lista[i].getCorreo().equals(Correo)){
                    posicion = i +1;
                }
            }
        }
        return posicion;
    }
    public boolean isFull(){
        boolean lleno = true;
        int n = this.findFreeSpace();
        if(n != 0){
            lleno = false;
        }
        return lleno;
    }
    public boolean isInLista(String dni, String correo){
        boolean enLista = false;
        for (int i=0; i<20; ++i){
            if (this.lista[i] != null && this.lista[i].getDni() != null && this.lista[i].getCorreo() != null){
                if(this.lista[i].getDni().equals(dni) || this.lista[i].getCorreo().equals(correo)){
                    enLista = true;
                }
            }
        }

        return enLista;
    }
    public int createCodigo(int num){
        int codigo;
        codigo = 1000 + (num * 100);
        return codigo;
    }


}
