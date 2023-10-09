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
public class GuardarMySQL {

     static final String JDBC_URL = "jdbc:mysql://localhost:3306/empresa";
     static final String USUARIO = "root";
     static final String PASSWORD = "user";
     
     public static void main(String[] args) throws SQLException {
        
         try(Connection conexion = DriverManager.getConnection(JDBC_URL, USUARIO,PASSWORD);
                 
                  ){
            
             //Establecer coneccion
             System.out.println("Conexión establecida con éxito");
             
             
             
             //Crear la Query que queremos ejecutar
                String ConsultaSQL = "INSERT INTO empleados(idEmpleados,nombres,apellidos,fechaNacimiento,salario,cargo) VALUES (?,?,?,?,?,?)";
                //Crear un objeto PreparedStatement para ejecutar consultas
                PreparedStatement preparedStatement = conexion.prepareStatement(ConsultaSQL);
             
             //Ejecutar la consulta 
             
             LocalDate fechaNacimiento = LocalDate.of(1988, Month.JULY, 15);
             Date fechaDate = Date.valueOf(fechaNacimiento);
             
             preparedStatement.setInt(1, 5);
             preparedStatement.setString(2, "Sofia Valeria");
             preparedStatement.setString(3,"Morales Fuentes" );
             preparedStatement.setDate(4, fechaDate);
             preparedStatement.setDouble(5, 437.345);
             preparedStatement.setString(6, "Community Manager");
             
             //Ejecutar la insercion
             
             int filasAfectadas = preparedStatement.executeUpdate();
             
             if(filasAfectadas >0){
                 System.out.println("Registros insertados con éxito ");
             }else{
                 System.out.println("No se pudieron insertar los registros ");
             }

                //Cerrar recurso
           preparedStatement.close();
         }catch(SQLException e){
             System.out.println("Error al insertar en la DB: "+ e.getMessage());
         }
    }
}
