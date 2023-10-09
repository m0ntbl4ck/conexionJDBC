package conexionjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author mont_
 */
public class ActualizarMySQL {

     static final String JDBC_URL = "jdbc:mysql://localhost:3306/empresa";
     static final String USUARIO = "root";
     static final String PASSWORD = "user";
     
     public static void main(String[] args) throws SQLException {
        
         try(Connection conexion = DriverManager.getConnection(JDBC_URL, USUARIO,PASSWORD);
                 
                  ){
            
             //Establecer coneccion
             System.out.println("Conexión establecida con éxito");
             

             //Crear la Query que queremos ejecutar
                String ConsultaSQL = "UPDATE empleados SET salario=?, cargo =? WHERE idEmpleados = 1";
                //Crear un objeto PreparedStatement para ejecutar consultas
                PreparedStatement preparedStatement = conexion.prepareStatement(ConsultaSQL);
             
             //Ejecutar la consulta 
            
             preparedStatement.setDouble(1, 123437.345);
             preparedStatement.setString(2, "Desarrollador Senior");
             
             //Ejecutar la insercion
             
             int filasAfectadas = preparedStatement.executeUpdate();
             
             if(filasAfectadas >0){
                 System.out.println("Registros actualizados con éxito ");
             }else{
                 System.out.println("No se pudieron actualizar los registros ");
             }

                //Cerrar recurso
           preparedStatement.close();
         }catch(SQLException e){
             System.out.println("Error al actualizar en la DB: "+ e.getMessage());
         }
    }
}

