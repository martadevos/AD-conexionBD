import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {

    public static void consultarTodo(Statement con, String tabla) {
        String sql = "SELECT * FROM ad2223." + tabla;
        try {
            Conexion.mostrarDatos(con.executeQuery(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultarOrdenEdad(Statement con, String tabla) {
        String sql = "SELECT * FROM ad2223." + tabla + " ORDER BY edad";
        try {
            Conexion.mostrarDatos(con.executeQuery(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultarOrdenApellidos(Statement con, String tabla) {
        String sql = "SELECT nombre, apellidos FROM ad2223." + tabla + " ORDER BY apellidos";
        try {
            Conexion.mostrarDatos(con.executeQuery(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultarMas30Anios(Statement con, String tabla) {
        String sql = "SELECT * FROM ad2223." + tabla + " WHERE edad > 30";
        try {
            Conexion.mostrarDatos(con.executeQuery(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultarNombrePorJ(Statement con, String tabla) {
        String sql = "SELECT * FROM ad2223." + tabla + " WHERE nombre LIKE 'J%'";
        try {
            Conexion.mostrarDatos(con.executeQuery(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultarNombrePorC_ApellidoPorA_OrdenEdadDesc(Statement con, String tabla) {
        String sql = "SELECT * FROM ad2223." + tabla + " WHERE nombre LIKE 'J%' OR apellidos LIKE 'A%' ORDER BY edad desc";
        try {
            Conexion.mostrarDatos(con.executeQuery(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultarMediaEdad(Statement con, String tabla) {
        String sql = "SELECT avg(edad) AS 'Media de edad' FROM ad2223." + tabla;
        try {
            Conexion.mostrarDatos(con.executeQuery(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultarApellidosConOhAh(Statement con, String tabla) {
        String sql = "SELECT * FROM ad2223." + tabla + " WHERE apellidos LIKE '%ar%' OR apellidos like '%oh%'";
        try {
            Conexion.mostrarDatos(con.executeQuery(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultarEntre24Y32Anios(Statement con, String tabla) {
        String sql = "SELECT * FROM ad2223." + tabla + " WHERE edad BETWEEN 24 AND 32";
        try {
            Conexion.mostrarDatos(con.executeQuery(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void consultarMas65Anios(Statement con, String tabla) {
        String sql = "SELECT * FROM ad2223." + tabla + " WHERE edad > 65";
        try {
            Conexion.mostrarDatos(con.executeQuery(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
