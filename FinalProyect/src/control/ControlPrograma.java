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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Factura;
import modelo.Habitacion;
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
    private Habitacion modeloHabitacion;
    private Factura modeloFactura;

    

    
  
    public ControlPrograma(Huesped modeloHuesped, Habitacion modeloHabitacion, Factura modeloFactura, Principal vistaPrincipal, Menu vistaMenu, VistaHuesped vistaHuesped, VistaFactura vistaFactura) {
    this.modeloHuesped = modeloHuesped;
    this.vistaPrincipal = vistaPrincipal;
    this.vistaMenu = vistaMenu;
    this.vistaHuesped = vistaHuesped;
    this.vistaFactura = vistaFactura;
    this.modeloHabitacion = modeloHabitacion;
    this.modeloFactura = modeloFactura;
    
    this.vistaPrincipal.getjButton2().addActionListener(this);
    this.vistaMenu.getjButton1().addActionListener(this);
    this.vistaMenu.getjButton2().addActionListener(this);
    this.vistaMenu.getjButton3().addActionListener(this);
    this.vistaHuesped.getjButton1().addActionListener(this);
    this.vistaHuesped.getjButton2().addActionListener(this);
    this.vistaHuesped.getjButton3().addActionListener(this);
    this.vistaFactura.getjButton1().addActionListener(this);
    this.vistaFactura.getjButton2().addActionListener(this);
    this.vistaFactura.getjButton3().addActionListener(this);
    this.vistaFactura.getjButton5().addActionListener(this);
    this.vistaFactura.getjButton6().addActionListener(this);
    
}

    
    public void actionPerformed(ActionEvent evento) {
        if(vistaPrincipal.getjButton2() == evento.getSource()){
            char clave[]=vistaPrincipal.getContraseña().getPassword();

            String clavedef=new String(clave);


            if (vistaPrincipal.getTextoUsuario().getText().equals("Admin") && clavedef.equals("12345")){


                            vistaPrincipal.dispose();


                            JOptionPane.showMessageDialog(null, "Bienvenido\n"
                            + "Has ingresado satisfactoriamente al sistema",   "Mensaje de bienvenida",
                            JOptionPane.INFORMATION_MESSAGE);
                            vistaMenu.setVisible(true);


                            //controlador.iniciarVista();



            }else {


                            JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                            + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
                            JOptionPane.ERROR_MESSAGE);
        }
        
        }
        
        
        if(vistaMenu.getjButton1() == evento.getSource()) {

            vistaMenu.dispose();
            vistaHuesped.setVisible(true);
        }
        //Agregar Huesped
        if(vistaHuesped.getjButton1() == evento.getSource()) {

            int dias;
            String nombre;
            int Clave;
            String email;
            int comida;
            int numHabitacion;
            String TipoHabitacion;

            Clave=Integer.parseInt(vistaHuesped.getjTextField1().getText());
            nombre=vistaHuesped.getjTextField2().getText();
            email=vistaHuesped.getjTextField4().getText();
            dias = Integer.parseInt(vistaHuesped.getjTextField3().getText());
            TipoHabitacion=(String)vistaHuesped.getjComboBox2().getSelectedItem();
            numHabitacion=Integer.parseInt(vistaHuesped.getjTextField7().getText());
            comida= 3;
            
            modeloHuesped.setClaveCliente(Clave);
            modeloHuesped.setNombre(nombre); 
            modeloHuesped.setEmail(email);
            modeloHuesped.setDias(dias);
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
        
        
        //Eliminar Huesped
        if(vistaFactura.getjButton2() == evento.getSource()) {
            int  claveCliente;
            String condicion;
            claveCliente = Integer.parseInt(vistaFactura.getjTextField1().getText());
            condicion = " clave = " + claveCliente;

            DAOHuesped daoCliente = new DAOHuesped();
            try{
              daoCliente.eliminar(condicion);
            }catch(Exception e){
                    e.printStackTrace();
            }
            vistaFactura.getjTextField1().setText(null);
            vistaFactura.getjTextField2().setText(null);
            vistaFactura.getjTextField3().setText(null);
            vistaFactura.getjTextField4().setText(null);
            vistaFactura.getjTextField7().setText(null);
            vistaFactura.getjTextField8().setText(null);
            vistaFactura.getjComboBox2().setSelectedItem("Suite");
            vistaFactura.getjTextArea1().setText(null);
        }
        
        
        //Cambiar Ventana
        if(vistaMenu.getjButton1() == evento.getSource()) {
          vistaMenu.dispose();
          vistaHuesped.setVisible(true);
        }
        
        if(vistaMenu.getjButton3() == evento.getSource()) {
          vistaMenu.dispose();
          vistaFactura.setVisible(true);
        } 

        //Buscar
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
          vistaFactura.getjTextField2().setText(cliente.getNombre());
          vistaFactura.getjTextField4().setText(cliente.getEmail());
          vistaFactura.getjTextField3().setText(String.valueOf(cliente.getDias()));
          vistaFactura.getjTextField7().setText(String.valueOf(cliente.getNumHabitacion()));
          vistaFactura.getjComboBox2().setSelectedItem(cliente.getHabitacion());
          
        } 
        
        if(vistaMenu.getjButton2() == evento.getSource()) {
          System.exit(0);
        }
        if(vistaHuesped.getjButton2() == evento.getSource()) {
            vistaHuesped.getjTextField1().setText(null);
            vistaHuesped.getjTextField2().setText(null);
            vistaHuesped.getjTextField4().setText(null);
            vistaHuesped.getjTextField3().setText(null);
            vistaHuesped.getjTextField7().setText(null);
        }
        
        //Regresar al Menu
        if(vistaHuesped.getjButton3() == evento.getSource()) {
            vistaMenu.setVisible(true);
            vistaHuesped.dispose();
        }
        //Regresar al Menu
        if(vistaFactura.getjButton6() == evento.getSource()) {
            vistaMenu.setVisible(true);
            vistaFactura.dispose();
        }
        
        if(vistaFactura.getjButton1() == evento.getSource()) {
            int clave;
            String nombre;
            String Habitacion;
            double total;
            int dias;
            String Fac;
            
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
            clave=cliente.getClaveCliente();
            nombre=cliente.getNombre();
            Habitacion=cliente.getHabitacion();
            dias=cliente.getDias();

            modeloHabitacion.setPrecioHabitacion(Habitacion);
            total=modeloHabitacion.getPrecioHabitacion();

            total=total*dias;
            total=total+900;
            vistaFactura.getjTextField8().setText(String.valueOf(total));
        } 
        
        
        
        if(vistaFactura.getjButton3() == evento.getSource()){
            int clave;
            String nombre;
            String Habitacion;
            double total;
            int dias;
            String Fac;
            
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
            clave=cliente.getClaveCliente();
            nombre=cliente.getNombre();
            Habitacion=cliente.getHabitacion();
            dias=cliente.getDias();

            modeloHabitacion.setPrecioHabitacion(Habitacion);
            total=modeloHabitacion.getPrecioHabitacion();

            total=total*dias;
            total=total+900;
            
            vistaFactura.getjTextField8().setText(String.valueOf(total));

            Fac=("\tHotel Rivera Resort\n"+"\nReferencia:\t\t\t45731"+
                                  "\n=====================================\t"+
                                  "\n=====================================\t"+ 
              "\n\nNumero del cliente:\t\t"+clave+
              "\n\nNombre:\t\t\t"+nombre+
              "\n\nTipo de habitación:\t\t"+Habitacion+
              "\n\n3 Comidas:\t\t\t$"+"300/c"+
                                  "\n=====================================\t"+
              "\n\nTotal:\t\t\t$"+total+
                                  "\n=====================================\t");
            
            modeloFactura.setFactura(Fac);
            vistaFactura.getjTextArea1().setText(Fac);
            
    
    
  } 
    }
    
}
