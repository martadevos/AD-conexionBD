package CRUD;

import java.sql.SQLException;
import java.sql.Statement;

public class Crear_RellenarTablas {
    public static void crearTablas(Statement con, String tabla, String[] campos){
        String tablaPacientes = "CREATE TABLE ad2223_mdevos.Pacientes(idPaciente int, nombre varchar(45), apellidos varchar(45), nss varchar(45));";
        String tablaReceta = "CREATE TABLE ad2223_mdevos.Receta(idMedicamento int, idReceta int, idPaciente int, fechaFin date);";
        String tablaMedicamentos = "CREATE TABLE ad2223_mdevos.Medicamentos(idMedicamento int, composicion varchar(45));";

        try {
            con.executeUpdate(tablaPacientes);
            con.executeUpdate(tablaReceta);
            con.executeUpdate(tablaMedicamentos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
