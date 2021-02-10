/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Huesped;

/**
 *
 * @author Irving Poot
 */
public class DAOHuesped extends DAOGeneral<Huesped>{
    public DAOHuesped() {
    }

    public int agregar(Huesped e) throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "INSERT INTO cliente (clave, nombre, fechaIngreso, fechaSalida, numhab, comida, correo, tipoHab)"+
                "VALUES ("+ e.getClaveCliente()+ ",'" + e.getNombre()+ "','" + 
                e.getFechaIngreso().toString() + "',"+e.getFechaSalida().toString()+"',"+e.getNumHabitacion()+"',"+e.getComida()+"',"+e.getEmail()+"',"+e.getHabitacion()+")";

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int eliminar(String condicion)throws SQLException{
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "DELETE FROM cliente WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int modificar(Huesped e, String condicion)throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "UPDATE cliente SET " +
                "nombre='"+e.getNombre()+"',"+
                "fechaIngreso = " + e.getFechaIngreso().toString() + "',"+
                "fechaSslida = "+ e.getFechaSalida()+ "',"+
                "numhab = "+ e.getNumHabitacion()+ "',"+ 
                "comida = "+e.getComida()+"',"+
                "correo = "+e.getEmail()+"',"+
                "tipoHab = "+e.getHabitacion()+
                " WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public ArrayList<Huesped> consultar(String condicion) throws SQLException{
        ArrayList<Huesped> lista = new ArrayList<Huesped>();
        Huesped e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM hotel.cliente " +
                (condicion==null || condicion.length()==0 ? "":"WHERE " + condicion);
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new Huesped(rs.getInt("clave"), rs.getString("nombre"),rs.getDate("FechaIn"),rs.getDate("FechaOut"),rs.getInt("numHabitacion"),rs.getInt("comida"),rs.getString("email"),rs.getString("TipoHabitacion"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }
}
