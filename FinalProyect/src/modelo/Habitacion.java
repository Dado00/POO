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
public class Habitacion {
    private String tipoHabitacion;
    private double precio;
    
    public Habitacion (String tipoHabitacion){
        this.tipoHabitacion=tipoHabitacion;
    }
    
    public Habitacion (){
        
    }
    
    public String getHabitacion() {
        return tipoHabitacion;
    }

    public void setHabitacion(String tipoHabitacion) {
        this.tipoHabitacion=tipoHabitacion;
    }
    
    public double getPrecioHabitacion() {
        return precio;
    }

    public void setPrecioHabitacion (String tipoHabitacion) {
        if(tipoHabitacion.equals("Suite")){
        precio=1500;
    }
       if(tipoHabitacion.equals("Individual")){
        precio=500;
    }
       if(tipoHabitacion.equals("Doble")){
        precio=1000;
    }
        
    }
    
}
