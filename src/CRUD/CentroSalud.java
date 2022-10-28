package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CentroSalud {
    public static Connection conectar(){
        Connection con = null;

        String password = "mdevos";
        String usuario = "mdevos";
        String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2223_mdevos?user=" + usuario
                + "&password=" + password;
        try {
            con = DriverManager.getConnection(url);
            if (con != null) {
                System.out.println("Se ha conectado correctamente");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar");
            e.printStackTrace();
        }
        return con;
    }

    private static void insertar(){}
    private static void listar(){}
    private static void modificar(){}
    private static void borrar(){}
}
