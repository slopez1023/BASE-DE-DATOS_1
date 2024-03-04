package org.example.APPLICATIONS;

import org.example.CONEXION.ConexionBD;
import org.example.MODELS.PRODUCTO;
import org.example.REPOSITORIO.Repository;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/proyecto";
        String user = "root";
        String password = "";
        try (Connection conn = DriverManager.getConnection(url,user,password);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM empresas");)

        {
            while (resultSet.next()) {

               System.out.print(resultSet.getInt("id"));
                System.out.print("|");
                System.out.print(resultSet.getString("nombre"));
                System.out.print("|");
                System.out.print(resultSet.getString("descripcion"));
                System.out.print("|");
                System.out.print(resultSet.getString("estado"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}