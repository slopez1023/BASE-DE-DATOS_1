package org.example.CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static String url = "jdbc:mysql://localhost:3306/proyecto";
    private static String user = "root";
    private static String password = "";
    private static Connection connection;
    public static Connection getInstance() throws SQLException {
        if(connection==null){
            connection =
                    DriverManager.getConnection(url,user,password);
        }
        return connection;
    }
}
