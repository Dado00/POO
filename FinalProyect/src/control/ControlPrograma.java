/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.DAOCliente;
import finalproyect.VistaHuesped;
import finalproyect.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import modelo.Huesped;
import modelo.Registro;

/**
 *
 * @author ivanj
 */
public class ControlPrograma implements ActionListener {
    
    private Registro modeloPrograma;
    private Principal vistaPrincipal;
    private VistaHuesped vistaHuesped;
    private Huesped modeloHuesped;
  
    public ControlPrograma(Registro modeloPrograma, Principal vistaPrincipal, VistaHuesped vistaHuesped, Huesped modeloHuesped) {
    this.modeloPrograma = modeloPrograma;
    this.vistaPrincipal = vistaPrincipal;
    this.vistaHuesped= vistaHuesped;
    this.modeloHuesped=modeloHuesped;
    

    this.vistaPrincipal.getjButton1().addActionListener(this);
    this.vistaPrincipal.getjButton2().addActionListener(this);
    this.vistaHuesped.getjButton1().addActionListener(this);
    this.vistaHuesped.getjButton2().addActionListener(this);
    
    
}
    
    public void actionPerformed(ActionEvent evento) {
    if(vistaHuesped.getjButton1() == evento.getSource()) {
    
        Date FechaIn;
        Date FechaOut;
        String nombre;
        int Clave;
        String email;
        int comida;
        int numHabitacion;
        String TipoHabitacion;
        
        Clave=Integer.parseInt(vistaHuesped.getjTextField1().getText());
        nombre=vistaHuesped.getjTextField2().getText();
        email=vistaHuesped.getjTextField4().getText();
        FechaIn=new Date (Long.parseLong(vistaHuesped.getjTextField5().getText()));
        FechaOut=new Date (Long.parseLong(vistaHuesped.getjTextField6().getText()));
        TipoHabitacion=(String)vistaHuesped.getjComboBox2().getSelectedItem();
        numHabitacion=Integer.parseInt(vistaHuesped.getjTextField7().getText());
        comida=(int)vistaHuesped.getjComboBox3().getSelectedItem();
        
        modeloHuesped.setClaveCliente(Clave);
        modeloHuesped.setNombre(nombre); 
        modeloHuesped.setEmail(email);
        modeloHuesped.setFechaIngreso(FechaIn);
        modeloHuesped.setFechaSalida(FechaOut);
        modeloHuesped.setHabitacion(TipoHabitacion);
        modeloHuesped.setNumHabitacion(numHabitacion);
        modeloHuesped.setComida(comida);
     
        }
    
//    if(vistaCliente.getjButton3() == evento.getSource()) {
//      ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
//      int  claveCliente;
//      String condicion;
//     
//      claveCliente = Integer.parseInt(vistaCliente.getjTextField1().getText());
//      condicion = " id_clientes = " + claveCliente;
//      DAOCliente daoCliente = new DAOCliente();
//      try{
//        listaClientes = daoCliente.consultar(condicion);
//      }catch(Exception e){
//              e.printStackTrace();
//      }
//      
//      Cliente cliente = listaClientes.get(0);
//      vistaCliente.getjTextField2().setText(cliente.getNombre());
//      vistaCliente.getjFormattedTextField1().setText(String.valueOf(cliente.getFechaIngreso()));
//      vistaCliente.getjCheckBox1().setSelected(cliente.isActivo());
//  } 
}
    
}
