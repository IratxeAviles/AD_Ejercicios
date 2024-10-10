package Ejercicios.MyAdmin;

import java.sql.*;

public class Ejercicio6_1 {
    public static void main(String[] args) {

        try {
            //Cargar el driver
            Class.forName("org.mariadb.jdbc.Driver");

            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pruebamyadmin?user=root");

            // Preparamos la consulta
            PreparedStatement sentencia = conexion.prepareStatement("SELECT apellido, oficio, salario FROM empleados WHERE dept_no = ?");
            sentencia.setInt(1, 1);
            //Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery();

            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros, se van visualizando
            while (resul.next()) {
                System.out.println(resul.getString(1) + " " +
                        resul.getString(2) + " " + resul.getFloat(3));
            }

            // Cerrar conexiones
            resul.close();
            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException cn) {
            System.out.println("Clase no encontrada");
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }
    }
}
