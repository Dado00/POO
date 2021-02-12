/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import control.ControlPrograma;
import finalproyect.Menu;
import finalproyect.Principal;
import finalproyect.VistaFactura;
import finalproyect.VistaHuesped;
import modelo.Huesped;

/**
 *
 * @author ivanj
 */
public class MainFactura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Huesped modeloHuesped = new Huesped();
        Principal vistaPrincipal = new Principal();
        Menu vistaMenu = new Menu();
        VistaHuesped vistaHuesped = new VistaHuesped();
        VistaFactura vistaFactura = new VistaFactura();;
        ControlPrograma controlPrograma = new ControlPrograma(modeloHuesped,vistaPrincipal,vistaMenu, vistaHuesped, vistaFactura);
        vistaPrincipal.setVisible(true);
        
        
    }
    
}
