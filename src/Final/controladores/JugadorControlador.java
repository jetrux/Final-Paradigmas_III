/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final.controladores;

import Final.objetos.Posicion;
import Final.dominio.Conexion;
import Final.objetos.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gaston
 */
public class JugadorControlador implements ICrud<Jugador>
{
    private Connection connection;    
    private Statement stmt;    
    private PreparedStatement ps;
    private ResultSet rs;    
    private String sql;
    private PosicionControlador posicionControlador;
    
    @Override
    public ArrayList<Jugador> listar() throws SQLException,Exception{        
     connection = Conexion.obtenerConexion ();
        try{            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM jugador";
            this.rs = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Jugador> jugadores = new ArrayList();
            
            while(rs.next())
            {                
                Jugador jugador = new Jugador();
                
                jugador.setId(rs.getInt("id"));
                jugador.setApellido(rs.getString("apellido"));
                jugador.setNombre(rs.getString("nombre"));
                jugador.setDoc(rs.getString("documento"));
                jugador.setEdad(rs.getInt("edad"));
                jugador.setPosicion(getPosicion(rs.getInt("posicion")));
                
                jugadores.add(jugador);                
            }
            return jugadores;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public boolean crear(Jugador entidad) throws SQLException, Exception{
        connection = Conexion.obtenerConexion ();
        this.sql="INSERT INTO jugador(apellido, nombre, documento, edad, posicion) VALUES (?, ?, ?, ?, ?)";
        
        ps = connection.prepareStatement(sql);
        ps.setString(1,entidad.getApellido());
        ps.setString(2,entidad.getNombre());
        ps.setString(3,entidad.getDoc());
        ps.setInt(4,entidad.getEdad());
        ps.setInt(5,entidad.getPosicion().getId());
        ps.executeUpdate();
        connection.close();
        
        return false;
    }
    
    @Override
    public boolean eliminar(Jugador entidad) throws SQLException, Exception{
        connection=Conexion.obtenerConexion();
        this.sql="DELETE FROM jugador WHERE id=?";
        
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getId());
       
        ps.executeUpdate();
        connection.close();
        return true;      
    }
    
    @Override
    public boolean modificar(Jugador entidad) throws SQLException, Exception {
        connection=Conexion.obtenerConexion();
        this.sql="UPDATE jugador SET apellido=?, nombre=?, documento=?, edad=?, posicion=? WHERE id=?";
        
        ps = connection.prepareStatement(sql);
        ps.setString(1,entidad.getApellido());
        ps.setString(2,entidad.getNombre());
        ps.setString(3,entidad.getDoc());
        ps.setInt(4,entidad.getEdad());
        ps.setInt(5,entidad.getPosicion().getId());
        ps.setInt(6, entidad.getId());
       
        ps.executeUpdate();
        connection.close();
        
        return true;
    }
    
    @Override
    public Jugador extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM jugador WHERE id = ?";
        
        ps = connection.prepareStatement(sql);            
        ps.setInt(1, id);
        
        this.rs   = ps.executeQuery();
        
        connection.close();
        
        this.rs.next();
        Jugador jugador = new Jugador();
        jugador.setId(id);
        jugador.setNombre(rs.getString("apellido"));
        jugador.setNombre(rs.getString("nombre"));
        jugador.setDoc(rs.getString("documento"));
        jugador.setEdad(rs.getInt("edad"));
        jugador.setPosicion(getPosicion(rs.getInt("posicion")));
        
        return jugador;
    }
    
    private Posicion getPosicion(Integer id) throws Exception
    {
     this.posicionControlador = new PosicionControlador();
     
     Posicion posicion = posicionControlador.extraer(id);
     
     return posicion;
    }  
}
