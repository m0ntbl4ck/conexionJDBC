
package conexionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mont_
 */
public class ConexionJDBC {

     static final String JDBC_URL = "jdbc:mysql://localhost:3306/empresa";
     static final String USUARIO = "root";
     static final String PASSWORD = "user";
     
     public static void main(String[] args) throws SQLException {
        
         try(Connection conexion = DriverManager.getConnection(JDBC_URL, USUARIO,PASSWORD)){
            
             //Establecer coneccion
             System.out.println("Conexión establecida con éxito");
         }catch(SQLException e){
             System.out.println("Error en la conexión a la DB: "+ e.getMessage());
         }
    }
    
}
