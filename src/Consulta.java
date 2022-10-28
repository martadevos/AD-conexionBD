import java.sql.*;

public class Consulta {

    public static void consultarTodo(Statement con, String tabla) {
        String sql = "SELECT * FROM ad2223." + tabla;
        try {
            Conexion.mostrarDatos(con.executeQuery(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultaPreparadaNombre(Connection con, String tabla, String letraNombre) {
        String sql = "SELECT * FROM ad2223." + tabla + " WHERE nombre LIKE ?";
        try {
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, letraNombre + "%");
            ResultSet rs = prepStatement.executeQuery();
            Conexion.mostrarDatos(rs);
            prepStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void consultaPreparadaNombreApellido(Connection con, String tabla, String letraNombre, String letraApellido) {
        String sql = "SELECT * FROM ad2223." + tabla + " WHERE nombre LIKE ? OR apellidos LIKE ?";
        try {
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, letraNombre + "%");
            prepStatement.setString(2, letraApellido + "%");
            ResultSet rs = prepStatement.executeQuery();
            Conexion.mostrarDatos(rs);
            prepStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void consultaPreparadaEdad(Connection con, String tabla, int edadMin, int edadMax) {
        String sql = "SELECT * FROM ad2223." + tabla + " WHERE edad BETWEEN ? AND ?";
        try {
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, edadMin);
            prepStatement.setInt(2, edadMax);
            ResultSet rs = prepStatement.executeQuery();
            Conexion.mostrarDatos(rs);
            prepStatement.close();
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
