package model;

/**
 *
 * @author SOFTWARE GALAXIA TV
 */
public class DatosDB {
    
    /*datos usuario*/
    private int idUsuario;
    private String name;
    private String lastName;
    private String email;

    /*datos producto*/
    private int idProducto;
    private String producto;
    private String descripcion;
    private int precio;
    
    public DatosDB(){
        
        /*inializamos las variables*/
        this.idUsuario=0;
        this.name="";
        this.lastName="";
        this.email="";
        
        this.idProducto=0;
        this.producto="";
        this.descripcion="";
        this.precio=0;
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    
    
    
    
    
    
}
