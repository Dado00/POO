/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import finalproyect.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Programa;

/**
 *
 * @author ivanj
 */
public class ControlPrograma implements ActionListener {
    
    private Programa modeloPrograma;
    private Principal vistaPrincipal;
  
    public ControlPrograma(Programa modeloPrograma, Principal vistaPrincipal) {
    this.modeloPrograma = modeloPrograma;
    this.vistaPrincipal = vistaPrincipal;

    this.vistaPrincipal.getjButton1().addActionListener(this);
    this.vistaPrincipal.getjButton2().addActionListener(this);
    
}
    
    public void actionPerformed(ActionEvent evento) {
    }
    
}
