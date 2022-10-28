import java.sql.*;

public class CambiaContrasena {
    private static String servidor = "jdbc:mysql://dns11036.phdns11.es";
    private static Connection connection_;
    private static java.sql.Statement con = null;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection_ = DriverManager.getConnection(servidor, "mdevos", "mdevos");
            if (connection_ != null) {
                con = connection_.createStatement();
                System.out.println("Conexion a base de datos test correcta . ");
                System.out.println(con.toString());
                cambiaContrasena(con);
                con.close();
            } else {
                System.out.println("Conexión fallida");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void cambiaContrasena(Statement con) {
        StringBuilder sql = new StringBuilder("SET PASSWORD FOR 'mdevos'@'%'=password('mdevos2003')");

        try {
            con.executeQuery(sql.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
