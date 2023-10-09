package conexionjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mont_
 */
public class ConsultarMySQL {

     static final String JDBC_URL = "jdbc:mysql://localhost:3306/empresa";
     static final String USUARIO = "root";
     static final String PASSWORD = "user";
     
     public static void main(String[] args) throws SQLException {
        
         try(Connection conexion = DriverManager.getConnection(JDBC_URL, USUARIO,PASSWORD);
                 
                  ){
            
             //Establecer coneccion
             System.out.println("Conexión establecida con éxito");
             
             //Crear un objeto Statement para ejecutar consultas
             
             Statement statement = conexion.createStatement();
             
             
             //Crear la Query que queremos ejecutar
                String ConsultaSQL = "SELECT * FROM empresa.empleados";
             
             
             //Ejecutar la consulta y obtener los resultados
             
             ResultSet resultSet =  statement.executeQuery(ConsultaSQL);
          /*   
            while(resultSet.next()){
             String nombres = resultSet.getString("nombres");
             
             System.out.println(
                         "Nombres: "+ nombres);
            }*/
          
          
           while(resultSet.next()){
                 
                 //Obtener cada fila
            int id = resultSet.getInt("idEmpleados");
            String nombres = resultSet.getString("nombres");
            String apellidos = resultSet.getString("apellidos");
            Date fechaNacimiento = resultSet.getDate("fechaNacimiento");
            double salario = resultSet.getDouble("salario");
            String cargo = resultSet.getString("cargo");
            
            
                 System.out.println("ID de Empleado: "+id
                         +", Nombres: "+ nombres
                         +", Apellidos: "+apellidos
                         +", Fecha de Nacimiento: "+fechaNacimiento
                         +", Salario: "+salario
                         +", Cargo: "+cargo);
             }
             
            //Cerrar los recursos
         resultSet.close();
         statement.close();
         }catch(SQLException e){
             System.out.println("Error en la conexión a la DB: "+ e.getMessage());
         }
    }
}