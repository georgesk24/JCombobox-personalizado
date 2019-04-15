package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author SOFTWARE GALAXIA
 */
public class ModelDatosDB {
    
    public ArrayList<DatosDB> getProductos(int idUsuario){
            
        Pool conexion = new Pool();
        Connection conectar=null;
        PreparedStatement pst;
        ResultSet rs;
        DatosDB datosDB;
        ArrayList list = new ArrayList();
        
        try{

            // obtenemos la conexion con la base de datos
            conectar = conexion.initializeDataSource().getConnection();
            
            if(conectar != null){
                                
                String sql ="SELECT productos.id, productos.producto, productos.descripcion, productos.precio "
                        +   "FROM usuarioproducto1 "
                        +   "INNER JOIN productos ON (usuarioproducto1.id_producto=productos.id) "
                        +   "INNER JOIN usuarios ON (usuarioproducto1.id_usuario=usuarios.id) "
                        +   "WHERE usuarios.id=?";
                
                pst = conectar.prepareStatement(sql);
                pst.setInt(1, idUsuario);
                
                rs = pst.executeQuery();
                                
                while(rs.next()){
                    
                    datosDB = new DatosDB();
                    datosDB.setIdProducto(rs.getInt("id"));
                    datosDB.setProducto(rs.getString("producto"));
                    datosDB.setDescripcion(rs.getString("descripcion"));
                    datosDB.setPrecio(rs.getInt("precio"));
                    list.add(datosDB);

                }
                 
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al realizar la operacion, intente mas tarde","ERROR",JOptionPane.ERROR_MESSAGE);
            }
                
        
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e , " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
        }finally{
        
            try{
                conectar.close();
            }catch(SQLException ex){
                System.out.println("error "+ex);
            }
        
        }
        
       return list;
         
    }    
   

    public ArrayList<DatosDB> getUsuarios(){
            
        Pool conexion = new Pool();
        Connection conectar=null;
        PreparedStatement pst;
        ResultSet rs;
        DatosDB datosDB;
        ArrayList list = new ArrayList();
        
        try{

            // obtenemos la conexion con la base de datos
            conectar = conexion.initializeDataSource().getConnection();
            
            if(conectar != null){
                                
                String sql ="SELECT id, nombre, apellido "
                        +   "FROM usuarios "
                        +   "WHERE 1";
                
                pst = conectar.prepareStatement(sql);                
                rs = pst.executeQuery();
                                
                while(rs.next()){
                    
                    datosDB = new DatosDB();
                    datosDB.setIdUsuario(rs.getInt("id"));
                    datosDB.setName(rs.getString("nombre"));
                    datosDB.setLastName(rs.getString("apellido"));
                    list.add(datosDB);

                }
                 
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al realizar la operacion, intente mas tarde","ERROR",JOptionPane.ERROR_MESSAGE);
            }
                
        
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e , " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
        }finally{
        
            try{
                conectar.close();
            }catch(SQLException ex){
                System.out.println("error "+ex);
            }
        
        }
        
       return list;
         
    }    

    
    

    
}
