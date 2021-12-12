public class Cliente {
    private Cliente[] lista = new Cliente[19];
    private String nombre;
    private String apellidos;
    private String fechaDia;
    private String fechaMes;
    private String fechaAño;
    private String dni;
    private String correo;
    private int codigo;

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
    public void SetListaCliente(){
        for (int i=0; i<19; ++i){
            this.lista[i] =  new Cliente();
        }
    }
    public void ViewListaClientes(){
        for(int i=0; i<19; ++i){
            System.out.println(this.lista[i]);
        }
    }


}
