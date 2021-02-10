/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author ivanj
 */
public class Huesped {
    private Date FechaIn;
    private Date FechaOut;
    private String nombre;
    private String apellido;
    private int clave;
    private String email;
    private int comida;
    private int numHabitacion;
    private String TipoHabitacion;
    
    public Huesped(int clave, String nombre, Date FechaIn, Date FechaOut,int numHabitacion,int comida, String email,String TipoHabitacion){
        this.clave=clave;
        this.nombre=nombre;
        this.email=email;
        this.FechaIn=FechaIn;
        this.FechaOut=FechaOut;
        this.TipoHabitacion=TipoHabitacion;
        this.numHabitacion=numHabitacion;
        this.comida=comida;
        
    }
        
    public Date getFechaIngreso() {
        return FechaIn;
    }

    public void setFechaIngreso(Date FechaIn) {
        this.FechaIn = FechaIn;
    }

    public Date getFechaSalida() {
        return FechaOut;
    }

    public void setFechaSalida(Date FechaOut) {
        this.FechaOut = FechaOut;
    }

    public int getClaveCliente() {
        return clave;
    }

    public void setClaveCliente(int id_clientes) {
        this.clave = id_clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getHabitacion() {
        return TipoHabitacion;
    }

    public void setHabitacion(String tipohabitacion) {
        this.TipoHabitacion = tipohabitacion;
    }
    
    public int getNumHabitacion() {
        return  numHabitacion;
    }

    public void setNumHabitacion(int numhabitacion) {
        this.numHabitacion = numhabitacion;
    }
    
    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    
}
