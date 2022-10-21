import java.sql.SQLException;
import java.sql.Statement;

public class Actualizacion {

    public static void actualizarLaboral(Statement con, String tabla){
        String sql = "UPDATE ad2223." + tabla +
                " SET laboral =" +
                " CASE" +
                " WHEN edad < 18 THEN 'estudiante'" +
                " WHEN edad > 65 THEN 'jubilado'" +
                " WHEN edad % 2 = 1 AND edad BETWEEN 18 AND 65 THEN 'parado'" +
                " WHEN edad % 2 = 0 AND edad BETWEEN 18 AND 65 THEN 'ocupado'" +
                " END;";
        try {
            con.executeUpdate(sql);
            Consulta.consultarTodo(con, tabla);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
