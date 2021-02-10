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
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    private double total;
    private String nombre;
    private int clave;
    private int comidas;
    private String Habitacion;

        
 

    
  
    public ControlPrograma(VistaHuesped vistaHuesped, Huesped modeloHuesped, VistaFactura vistaFactura, Menu vistaMenu) {
    this.vistaHuesped= vistaHuesped;
    this.modeloHuesped=modeloHuesped;
    this.vistaFactura= vistaFactura;
    this.vistaMenu = vistaMenu;

    
    this.vistaPrincipal.getjButton2().addActionListener(this);
    this.vistaHuesped.getjButton1().addActionListener(this);
    this.vistaHuesped.getjButton2().addActionListener(this);
    this.vistaFactura.getjButton1().addActionListener(this);
    this.vistaFactura.getjButton2().addActionListener(this);
    this.vistaFactura.getjButton3().addActionListener(this);
    this.vistaFactura.getjButton5().addActionListener(this);
    
    
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
        
        DAOHuesped daoHuesped = new DAOHuesped();
      try{
        daoHuesped.agregar(modeloHuesped);
      }catch(Exception e){
              e.printStackTrace();
      }
        
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
      vistaHuesped.getjTextField7().setText(String.valueOf(cliente.getNumHabitacion()));
      vistaHuesped.getjComboBox3().setSelectedItem(cliente.getComida());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 
        Date fechaInicial=(cliente.getFechaIngreso());
        Date fechaFinal=(cliente.getFechaSalida());
 
        int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
 
        System.out.println("Hay "+dias+" dias de diferencia");
        String aux;
        aux=cliente.getHabitacion();
        if(aux=="Individual"){
        total=dias*500;
    }
        if(aux=="Suite"){
        total=dias*1500;
    }
        if(aux=="Doble"){
        total=dias*1000;
    }
        int num;
        num=(cliente.getComida())*300;
        Habitacion=aux;
        comidas=num;
        nombre=cliente.getNombre();
        total=total+num;
        clave=cliente.getClaveCliente();
    
    }
    if(vistaFactura.getjButton1() == evento.getSource()){
    vistaFactura.getjTextField8().setText(String.valueOf(total));
    
    
    vistaFactura.getjTextArea1("\tHotel Rivera Resort\n"+"Referencia:\t\t\t45731"+
                                "\n================================\t"+
                                "\n================================\t"+ 
            "\nNumero del clinete:\t\t\t"+clave+
            "\nNombre:\t\t\t"+nombre+
            "\nTipo de habitación:\t\t\t"+Habitacion+
            "\nComidas:\t\t\t"+comidas+
                                "\n================================\t"+
            "\nTotal:\t\t\t"+total+
                                "\n================================\t");
    
    
  } 
    
    
}
    
}
