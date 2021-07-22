/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final.controladores;

import Final.dominio.Conexion;
import Final.objetos.Posicion;
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
public class PosicionControlador implements ICrud<Posicion>
{
    private Connection connection;
    private Statement statementmt;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
/*
    @Override
    public boolean crear(Posicion entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO productos (nombre,descripcion,precio,fecha_creacion, categoria_id) VALUES (?,?,?,?,?)";
        //Date fecha = new Date(entidad.getFechaCreacion().getTime());
        
        try {
            ps = connection.prepareStatement(sql);
            //agregar aqui
            ps.executeUpdate();
            connection.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Producto entidad) throws SQLException, Exception {
        connection=Conexion.obtenerConexion();
        this.sql="DELETE FROM productos WHERE id=?";
        
        ps = connection.prepareStatement(sql);
        //agregar aqui
       
        ps.executeUpdate();
        connection.close();
        return true;
    }
*/
    @Override
    public Posicion extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM posicion WHERE id = ?";
        
        ps = connection.prepareStatement(sql);            
            ps.setInt(1, id);
                        
            this.rs   = ps.executeQuery();
            
            connection.close();
            
            this.rs.next();
            Posicion posicion = new Posicion();
            posicion.setId(id);
            posicion.setNombre(rs.getString("nombre"));
            return posicion;
    }
/*
    @Override
    public boolean modificar(Producto entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        sql = "UPDATE productos SET categoria_id=?, nombre=?, precio=?, descripcion=?, fecha_creacion=? WHERE id=?";
       Date fecha = new Date(entidad.getFechaCreacion().getTime());
        
        ps = connection.prepareStatement(sql);
    //agregar aqui
        ps.executeUpdate();
        
        connection.close();
        return true;
    }*/

    @Override
    public ArrayList <Posicion> listar() throws Exception {
         connection = Conexion.obtenerConexion ();
        try{
            
            this.statementmt = connection.createStatement();
            this.sql = "SELECT * FROM posicion";
            this.rs   = statementmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Posicion> posiciones = new ArrayList();
            
            while(rs.next())
            {                
                Posicion posicion = new Posicion();
                
                posicion.setNombre(rs.getString("nombre"));
                posicion.setId(rs.getInt("id"));

                posiciones.add(posicion);
                
            }
            return posiciones;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean crear(Posicion entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Posicion entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Posicion entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
