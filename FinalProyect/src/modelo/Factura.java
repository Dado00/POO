/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ivanj
 */
public class Factura {
    String Fac;
    
    public Factura (String Fact){
        this.Fac=Fact;
    }
    
    public Factura (){
        
    }
    
    public String getFactura() {
        return Fac;
    }

    public void setFactura(String Fact) {
        this.Fac=Fact;
    }
}
