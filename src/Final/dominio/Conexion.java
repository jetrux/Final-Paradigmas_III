/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final.dominio;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Gaston
 */
public class Conexion {
    
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/final_paradigmas";
    
    private static Connection conn = null;
    
    public static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
     
         try {
            //Set Values from  .env configuration file
            //Properties enviromentsVaribles = Conexion.getProperties();
            final String  USER = "postgres"; 
            final String  PASS = "admin";

            Class.forName(JDBC_DRIVER);
             //STEP 3: Open a connection
      
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         } catch (Exception e) {
            e.printStackTrace();
         }
      
      return conn;
   }
   
   public static void cerrar() throws SQLException {
      if (conn != null) {
         conn.close();
      }
   }

   public static Properties  getProperties() throws Exception {
      FileReader reader=new FileReader(".env");
      Properties p = new Properties();
      p.load(reader);
      return p;
   }
}
