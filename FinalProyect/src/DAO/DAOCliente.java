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
/**
 *
 * @author Irving Poot
 */
public class DAOCliente extends DAOGeneral<Cliente>{
    public DAOCliente() {
    }

    public int agregar(Cliente e) throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "INSERT INTO cliente (clave, nombre, fechaIngreso, fechaSalida, numhab, comida, correo, tipoHab)"+
                "VALUES ("+ e.getClaveCliente()+ ",'" + e.getNombre()+ "','" + 
                e.getFechaIngreso().toString() + "',"+e.getFechaSalida().toString()+e.getNumHab()+e.getComidas()+e.getTipoHab()+")";

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

    public int modificar(Cliente e, String condicion)throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "UPDATE cliente SET " +
                "nombre='"+e.getNombre()+"',"+
                "fechaIngreso = " + e.getFechaIngreso().toString() + "',"+
                "fechaSslida = "+ e.isActivo()+ "',"+
                "numhab = "+ e.getNumHab()+ "',"+ 
                "comida = "+e.getComida()+"',"+
                "correo = "+e.getCorreo()+"',"+
                "tipoHab = "+e.getHab()+
                " WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public ArrayList<Cliente> consultar(String condicion) throws SQLException{
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        Cliente e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM hotel.cliente " +
                (condicion==null || condicion.length()==0 ? "":"WHERE " + condicion);
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new Cliente(rs.getInt("clave"), rs.getString("nombre"),rs.getDate("fechaIngreso"),rs.getDate("fechaSalida"),rs.getInt("numhab"),rs.getInt("comida"),rs.getString("correo"),rs.getInt("tipoHab"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }
}
