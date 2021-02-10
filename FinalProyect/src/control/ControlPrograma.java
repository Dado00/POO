/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import finalproyect.Huesped;
import finalproyect.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import modelo.Registro;

/**
 *
 * @author ivanj
 */
public class ControlPrograma implements ActionListener {
    
    private Registro modeloPrograma;
    private Principal vistaPrincipal;
    private Huesped vistaHuesped;
  
    public ControlPrograma(Registro modeloPrograma, Principal vistaPrincipal, Huesped vistaHuesped) {
    this.modeloPrograma = modeloPrograma;
    this.vistaPrincipal = vistaPrincipal;
    this.vistaHuesped= vistaHuesped;

    this.vistaPrincipal.getjButton1().addActionListener(this);
    this.vistaPrincipal.getjButton2().addActionListener(this);
    this.vistaHuesped.getjButton1().addActionListener(this);
    
    
}
    
    public void actionPerformed(ActionEvent evento) {
    if(vistaHuesped.getjButton1() == evento.getSource()) {
    
        private Date FechaIn;
        private Date FechaOut;
        private String nombre;
        private String apellido;
        private int Clave;
        private String email;
        private int comida;
        private int numHabitacion;
        private String TipoHabitacion;
      
     
        }
}
    
}
