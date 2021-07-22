/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final.controladores;

import Final.dominio.Conexion;
import Final.objetos.Equipo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gaston
 */
public class EquipoControlador implements ICrud<Equipo>
{
    private Connection connection;    
    private Statement stmt;    
    private PreparedStatement ps;
    private ResultSet rs;    
    private String sql;
    private JugadorControlador jugadorControlador;
    
    @Override
    public ArrayList<Equipo> listar() throws SQLException,Exception{        
     connection = Conexion.obtenerConexion ();
        try{            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM equipo";
            this.rs = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Equipo> equipos = new ArrayList();
            
            while(rs.next())
            {                
                Equipo equipo = new Equipo();
                
                equipo.setId(rs.getInt("id"));
                equipo.setNombre(rs.getString("nombre"));
                equipo.setCapitan(rs.getInt("capitan"));
                equipo.setFecha_alta(rs.getDate("fecha_alta"));
                
                equipos.add(equipo);                
            }
            return equipos;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public boolean crear(Equipo entidad) throws SQLException, Exception{
        connection = Conexion.obtenerConexion ();
        this.sql="INSERT INTO equipo(nombre, capitan, fecha_alta) VALUES (?, ?, ?)";
        Date fecha = new Date(entidad.getFecha_alta().getTime());
        
        ps = connection.prepareStatement(sql);
        ps.setString(1,entidad.getNombre());
        ps.setInt(2,entidad.getCapitan());
        ps.setDate(3,fecha);        
        ps.executeUpdate();
        connection.close();
        
        return false;
    }
    
    @Override
    public boolean eliminar(Equipo entidad) throws SQLException, Exception{
        connection=Conexion.obtenerConexion();
        this.sql="DELETE FROM equipo WHERE id=?";
        
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getId());
       
        ps.executeUpdate();
        connection.close();
        return true;      
    }
    
    @Override
    public boolean modificar(Equipo entidad) throws SQLException, Exception {
        connection=Conexion.obtenerConexion();
        this.sql="UPDATE equipo SET nombre=?, capitan=?, fecha_alta=? WHERE id=?";
        Date fecha = new Date(entidad.getFecha_alta().getTime());
        
        ps = connection.prepareStatement(sql);
        ps.setString(1,entidad.getNombre());
        ps.setInt(2,entidad.getCapitan());
        ps.setDate(3,fecha);
        ps.setInt(4, entidad.getId());
       
        ps.executeUpdate();
        connection.close();
        
        return true;
    }
    
    @Override
    public Equipo extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM equipo WHERE id = ?";
        
        ps = connection.prepareStatement(sql);            
        ps.setInt(1, id);
        
        this.rs   = ps.executeQuery();
        
        connection.close();
        
        this.rs.next();
        Equipo equipo = new Equipo();
        equipo.setId(id);
        equipo.setNombre(rs.getString("nombre"));
        equipo.setCapitan(rs.getInt("capitan"));
        equipo.setFecha_alta(rs.getDate("razon_social"));
        
        return equipo;
    }
    
    
}
