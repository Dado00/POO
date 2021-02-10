/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import finalproyect.Menu;
import DAO.DAOHuesped;
import finalproyect.VistaHuesped;
import finalproyect.Principal;
import finalproyect.VistaFactura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import modelo.Huesped;


/**
 *
 * @author ivanj
 */
public class ControlPrograma implements ActionListener {
    
    private Principal vistaPrincipal;
    private VistaHuesped vistaHuesped;
    private Huesped modeloHuesped;
    private Menu vistaMenu;
    private VistaFactura vistaFactura;

    

    
  
    public ControlPrograma(Menu vistaMenu, VistaHuesped vistaHuesped, VistaFactura vistaFactura) {
    this.vistaMenu = vistaMenu;
    this.vistaHuesped = vistaHuesped;
    this.vistaFactura = vistaFactura;
    
    
    this.vistaMenu.getjButton1().addActionListener(this);
    this.vistaMenu.getjButton2().addActionListener(this);
    this.vistaMenu.getjButton3().addActionListener(this);
    this.vistaHuesped.getjButton1().addActionListener(this);
    this.vistaHuesped.getjButton2().addActionListener(this);
    
}

    
    public void actionPerformed(ActionEvent evento) {
        if(vistaMenu.getjButton1() == evento.getSource()) {

            vistaMenu.dispose();
            vistaHuesped.setVisible(true);
        }
        
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

            DAOHuesped daoHuesped = new DAOHuesped();
          try{
            daoHuesped.agregar(modeloHuesped);
          }catch(Exception e){
                  e.printStackTrace();
          }
        }
        

        if(vistaMenu.getjButton2() == evento.getSource()) {
          vistaMenu.dispose();
          vistaFactura.setVisible(true);
        } 

        if(vistaFactura.getjButton5() == evento.getSource()) {
          ArrayList<Huesped> listaClientes = new ArrayList<Huesped>();
          int  claveCliente;
          String condicion;

          claveCliente = Integer.parseInt(vistaFactura.getjTextField1().getText());
          condicion = " clave = " + claveCliente;
          DAOHuesped daoCliente = new DAOHuesped();
          try{
            listaClientes = daoCliente.consultar(condicion);
          }catch(Exception e){
                  e.printStackTrace();
          }

          Huesped cliente = listaClientes.get(0);
          vistaHuesped.getjTextField2().setText(cliente.getNombre());
          vistaHuesped.getjTextField4().setText(cliente.getEmail());
          vistaHuesped.getjTextField5().setText(String.valueOf(cliente.getFechaIngreso()));
          vistaHuesped.getjTextField6().setText(String.valueOf(cliente.getFechaSalida()));
          vistaHuesped.getjComboBox2().setSelectedItem(cliente.getHabitacion());
          vistaHuesped.getjComboBox3().setSelectedItem(cliente.getComida());
        } 
}
    
}
