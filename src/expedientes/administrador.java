package expedientes;


public class administrador {
    
    private int id_administrador;
    private int id_almacen;
    private String usuario;
    private String contrasena;

    public administrador(String _id_administrador, String _id_almacen,
       String _usuario, String _contrasena) {
        
       setId_administrador(Integer.parseInt (_id_administrador));
       setId_almacen(Integer.parseInt (_id_almacen));
       setUsuario(_usuario);
       setContrasena(_contrasena);
       
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }
    

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
}
