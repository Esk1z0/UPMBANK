public class Cliente {
    String nombre;
    String apellidos;
    String fechaDia;
    String fechaMes;
    String fechaAño;
    String dni;
    String correo;
    int codigo;
    public void listaCliente(){
        Cliente[] listaClientes = new Cliente[20];
        for (int i=0; i<20; ++i){
            listaClientes[i] =  new Cliente();
        }
    }


}
