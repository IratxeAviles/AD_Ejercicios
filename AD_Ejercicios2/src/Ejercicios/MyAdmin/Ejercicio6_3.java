package Ejercicios.MyAdmin;

import java.sql.*;

public class Ejercicio6_3 {
    public static void main(String[] args) {
        try {
            //Cargar el driver
            Class.forName("org.mariadb.jdbc.Driver");

            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pruebamyadmin?user=root");

            PreparedStatement sentencia = conexion.prepareStatement("SELECT apellido, salario FROM empleados WHERE apellido = ?");
            sentencia.setString(1, args[0]);
            ResultSet resul = sentencia.executeQuery();
            leer(resul);

            PreparedStatement update = conexion.prepareStatement("UPDATE empleados SET salario = salario * 1.1 WHERE apellido = ?");
            update.setString(1, args[0]);
            update.executeUpdate();
            PreparedStatement sentencia2 = conexion.prepareStatement("SELECT apellido, salario FROM empleados WHERE apellido = ?");
            sentencia2.setString(1, args[0]);
            ResultSet resul2 = sentencia.executeQuery();

            leer(resul2);

            // Cerrar conexiones
            resul.close();
            resul2.close();
            sentencia.close();
            sentencia2.close();
            conexion.close();
        } catch (ClassNotFoundException cn) {
            System.out.println("Clase no encontrada");
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }
    }


    public static void leer(ResultSet resul) throws SQLException {
        while (resul.next()) {
            System.out.println(resul.getString(1) + " " +
                    resul.getString(2));
        }
    }
}
