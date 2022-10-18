import java.sql.*;

public class Conexion {
    private static String servidor = "jdbc:mysql://dns11036.phdns11.es";
    private static Connection connection_;
    private static java.sql.Statement con = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection_ = DriverManager.getConnection(servidor, "ad2223", "nervion");
            if (connection_ != null) {
                con = connection_.createStatement();
                System.out.println("Conexion a base de datos test correcta . ");
                System.out.println(con.toString());
                String[] campos = new String[4];
                campos[0] = "ID int";
                campos[1] = "nombre varchar(255)";
                campos[2] = "apellidos varchar(255)";
                campos[3] = "edad int";
                crearTabla(con, "mdevos", campos);
            } else {
                System.out.println("Conexión fallida");
            }

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void crearTabla(Statement con, String tabla, String[] campos) throws SQLException {
        StringBuilder sql = new StringBuilder("CREATE TABLE " + tabla + "(");

        for (int i = 0;i<campos.length-1;i++) {
            sql.append(campos[i]);
            if(i<campos.length-1) sql.append(", ");
        }
        sql.append(");");
        con.executeQuery(sql.toString());
    }

}