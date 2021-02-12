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
import java.util.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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

    

    
  
    public ControlPrograma(Huesped modeloHuesped, Principal vistaPrincipal, Menu vistaMenu, VistaHuesped vistaHuesped, VistaFactura vistaFactura) {
    this.modeloHuesped = modeloHuesped;
    this.vistaPrincipal = vistaPrincipal;
    this.vistaMenu = vistaMenu;
    this.vistaHuesped = vistaHuesped;
    this.vistaFactura = vistaFactura;
    
    this.vistaPrincipal.getjButton2().addActionListener(this);
    this.vistaMenu.getjButton1().addActionListener(this);
    this.vistaMenu.getjButton2().addActionListener(this);
    this.vistaMenu.getjButton3().addActionListener(this);
    this.vistaHuesped.getjButton1().addActionListener(this);
    this.vistaHuesped.getjButton2().addActionListener(this);
    
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
            comida= 1;
//                    vistaHuesped.getjComboBox3().getItemAt(vistaHuesped.getjComboBox3().getSelectedIndex());
            
            modeloHuesped.setClaveCliente(Clave);
            modeloHuesped.setNombre(nombre); 
            modeloHuesped.setEmail(email);
            modeloHuesped.setDias(dias);
            modeloHuesped.setHabitacion(TipoHabitacion);
            modeloHuesped.setNumHabitacion(numHabitacion);
            modeloHuesped.setComida(comida);

//            DAOHuesped daoHuesped = new DAOHuesped();
//            try{
//              daoHuesped.agregar(modeloHuesped);
//            }catch(Exception e){
//                    e.printStackTrace();
//            }
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
          vistaFactura.getjTextField2().setText(cliente.getNombre());
          vistaFactura.getjTextField4().setText(cliente.getEmail());
          vistaFactura.getjTextField3().setText(String.valueOf(cliente.getDias()));
          vistaFactura.getjComboBox2().setSelectedItem(cliente.getHabitacion());
          vistaFactura.getjComboBox3().setSelectedItem(cliente.getComida());
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
        
//        if(vistaFactura.getjButton1() == evento.getSource()){
//    vistaFactura.getjTextField8().setText(String.valueOf(total));
//    
//    
//    vistaFactura.getjTextArea1("\tHotel Rivera Resort\n"+"Referencia:\t\t\t45731"+
//                                "\n================================\t"+
//                                "\n================================\t"+ 
//            "\nNumero del clinete:\t\t\t"+clave+
//            "\nNombre:\t\t\t"+nombre+
//            "\nTipo de habitación:\t\t\t"+Habitacion+
//            "\nComidas:\t\t\t"+comidas+
//                                "\n================================\t"+
//            "\nTotal:\t\t\t"+total+
//                                "\n================================\t");
//    
//    
//  } 
    }
    
}
