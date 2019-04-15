package controller;

import ejemplocombobox.ComboboxIdAndValue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DatosDB;
import model.ModelDatosDB;

/**
 *
 * @author SOFTWARE GALAXIA
 */
public class Controller implements ActionListener{

    private final ComboboxIdAndValue view;

    public final void events(){
        view.JcUsuario.addActionListener(this);
    }
    
    public Controller(ComboboxIdAndValue view){
        
        this.view=view;
        getUsuarios();
        
        Item item = (Item) view.JcUsuario.getSelectedItem();
        getProductos(item.getId());
        events();
        
    }

    
    public final void getUsuarios(){
        
        ArrayList<DatosDB> list;
        ModelDatosDB model = new ModelDatosDB();
        
        list = model.getUsuarios();
    
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                int idUsuario = list.get(i).getIdUsuario();
                String nombre = list.get(i).getName() + " " + list.get(i).getLastName();
                view.JcUsuario.addItem(new Item(idUsuario, nombre));
            }            
        }else{
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados en la Base de datos", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
        }

    }
    
    public final void getProductos(int id){
        
        ArrayList<DatosDB> list;
        ModelDatosDB model = new ModelDatosDB();
        
        list = model.getProductos(id);
    
        if(list.size()>0){
            
            for (int i = 0; i < list.size(); i++) {

                DefaultTableModel modelTable = (DefaultTableModel) view.tablaProductos.getModel();
                Object [] fila=new Object[4];

                fila[0]=list.get(i).getIdProducto();
                fila[1]=list.get(i).getProducto();
                fila[2]=list.get(i).getDescripcion();
                fila[3]=list.get(i).getPrecio();

                modelTable.addRow(fila);
                view.tablaProductos.setModel(modelTable);            
 
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "No se obtuvo resultados de la consulta", 
            "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    public void eliminarCeldas(){
        
        DefaultTableModel model = (DefaultTableModel) view.tablaProductos.getModel();
        
        while(view.tablaProductos.getRowCount()>0){
            model.removeRow(0);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    
        Object evt = ae.getSource();
        
        if(evt.equals(view.JcUsuario)){
            
            eliminarCeldas();

            Item item = (Item) view.JcUsuario.getSelectedItem();            
            getProductos(item.getId());
            
            
        }
        
        
    }
    
}

