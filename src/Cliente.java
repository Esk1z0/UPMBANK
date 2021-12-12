public class Cliente {
    private Cliente[] lista = new Cliente[20];
    private String nombre;
    private String apellidos;
    private String fechaDia;
    private String fechaMes;
    private String fechaAño;
    private String dni;
    private String correo;
    private int codigo;

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
    public void ViewCliente(){
        System.out.println("Cliente "+this.toString()+"{ nombre: "+this.getNombre()+" apellidos: "+this.getApellidos()+
                "Fecha de nacimiento: "+this.getFechaDia()+"/"+this.getFechaMes()+"/"+this.getFechaAño()+
                " DNI: "+this.getDni()+" codigo: "+this.getCodigo()+" correo: "+this.getCorreo()+" }");
    }

    public void CreateListaCliente(){
        for (int i=0; i<20; ++i){
            this.lista[i] =  new Cliente();
        }
    }
    public void ViewListaClientes(){
        for(int i=0; i<20; ++i){
            System.out.println(this.lista[i]);
        }
    }


}
