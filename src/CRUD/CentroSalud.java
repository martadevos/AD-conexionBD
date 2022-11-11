package CRUD;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class CentroSalud {

    public static Connection conectar() {
        Connection con = null;

        String password = "1234";
        String usuario = "ad2223_mdevos";
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

    public static void crearTablas(Statement st) {
        String tablaPacientes = "CREATE TABLE ad2223_mdevos.Pacientes(idPaciente int AUTO_INCREMENT PRIMARY KEY, nombre varchar(45), apellidos varchar(45), nss varchar(45));";
        String tablaMedicamentos = "CREATE TABLE ad2223_mdevos.Medicamentos(idMedicamento int AUTO_INCREMENT PRIMARY KEY, composicion varchar(100));";
        String tablaReceta = "CREATE TABLE ad2223_mdevos.Receta(idReceta int NOT NULL AUTO_INCREMENT PRIMARY KEY, idMedicamento int, idPaciente int, fechaFin date, CONSTRAINT FK_PacienteReceta FOREIGN KEY (idPaciente) REFERENCES Pacientes(idPaciente) ON UPDATE CASCADE ON DELETE CASCADE, CONSTRAINT FK_MedicamentoReceta FOREIGN KEY (idMedicamento) REFERENCES Medicamentos(idMedicamento) ON UPDATE CASCADE ON DELETE CASCADE);";

        eliminarTabla(st, "Receta");
        eliminarTabla(st, "Pacientes");
        eliminarTabla(st, "Medicamentos");
        try {
            st.executeUpdate(tablaPacientes);
            st.executeUpdate(tablaMedicamentos);
            st.executeUpdate(tablaReceta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertar(Statement st, String tablaInsertar) {
        Scanner s = new Scanner(System.in);
        String datos;
        switch (tablaInsertar) {
            case "Pacientes" -> System.out.println("Introduzca los datos con el siguiente formato: 'nombre', 'apellidos', 'nss'");
            case "Receta" -> System.out.println("Introduzca los datos con el siguiente formato: idMedicamento, idPaciente, 'YYMMDD'");
            case "Medicamentos" -> System.out.println("Introduzca los datos con el siguiente formato: 'composicion'");
        }
        datos = s.nextLine();
        s.close();
        try {
            st.executeUpdate("INSERT INTO ad2223_mdevos." + tablaInsertar + " values (" + datos + ");");
        } catch (SQLException e) {
            System.out.println("Error: Clase CentroSalud, método insertar para la tabla: " + tablaInsertar);
            e.printStackTrace();
        }
    }

    public static void listar(Statement st, String tablaListar) {
        try {
            mostrarDatos(st.executeQuery("SELECT * FROM ad2223_mdevos." + tablaListar));
        } catch (SQLException e) {
            System.out.println("Error: Clase CentroSalud, método listar para la tabla: " + tablaListar);
            e.printStackTrace();
        }
    }

    public static void modificar(Statement st, String tablaModificar) {
        Scanner s = new Scanner(System.in);
        int id;
        StringBuilder sql = new StringBuilder("UPDATE ad2223_mdevos." + tablaModificar + " SET ");
        switch (tablaModificar) {
            case "Pacientes" -> {
                System.out.println("Introduzca idPaciente");
                id = s.nextInt();
                System.out.println("Introduzca nombre");
                sql.append("nombre = '").append(s.nextLine()).append("'");
                System.out.println("Introduzca apellidos");
                sql.append("apellidos = '").append(s.nextLine()).append("'");
                System.out.println("Introduzca nss");
                sql.append("nss = '").append(s.nextLine()).append("' WHERE idPaciente = ").append(id);
            }
            case "Receta" -> {
                System.out.println("Introduzca idReceta");
                id = s.nextInt();
                System.out.println("Introduzca idMedicamento");
                sql.append("idMedicamento = '").append(s.nextLine()).append("'");
                System.out.println("Introduzca idPaciente");
                sql.append("idPaciente = '").append(s.nextLine()).append("'");
                System.out.println("Introduzca fechaFin");
                sql.append("fechaFin = '").append(s.nextLine()).append("' WHERE idReceta = ").append(id);
            }
            case "Medicamentos" -> {
                System.out.println("Introduzca idMedicamento");
                id = s.nextInt();
                System.out.println("Introduzca composicion");
                sql.append("composicion = '").append(s.nextLine()).append("' WHERE idMedicamento = ").append(id);
            }
        }
        s.close();
        try {
            st.executeUpdate(String.valueOf(sql));
        } catch (SQLException e) {
            System.out.println("Error: Clase CentroSalud, método modificar para la tabla: " + tablaModificar);
            e.printStackTrace();
        }
    }

    public static void borrarRegistro(Statement st, String tablaModificar) {
        Scanner s = new Scanner(System.in);
        StringBuilder sql = new StringBuilder("DELETE FROM ad2223_mdevos." + tablaModificar);
        switch (tablaModificar) {
            case "Pacientes" -> {
                System.out.println("Introduzca idPaciente");
                sql.append("WHERE idPaciente = ").append(s.nextInt());
            }
            case "Receta" -> {
                System.out.println("Introduzca idReceta");
                sql.append("WHERE idReceta = ").append(s.nextInt());
            }
            case "Medicamentos" -> {
                System.out.println("Introduzca idMedicamento");
                sql.append("WHERE idMedicamento = ").append(s.nextInt());
            }
        }
        s.close();
        try {
            st.executeUpdate(String.valueOf(sql));
        } catch (SQLException e) {
            System.out.println("Error: Clase CentroSalud, método borrarRegistro para la tabla: " + tablaModificar);
            e.printStackTrace();
        }
    }
    public static void borrarTodosRegistros(Statement st, String tablaModificar) {
        try {
            st.executeUpdate("DELETE FROM ad2223_mdevos." + tablaModificar);
        } catch (SQLException e) {
            System.out.println("Error: Clase CentroSalud, método borrarTodosRegistros para la tabla: " + tablaModificar);
            e.printStackTrace();
        }
    }

    public static void eliminarTabla(Statement st, String tablaModificar) {
        try {
            st.executeUpdate("DROP TABLE IF EXISTS ad2223_mdevos." + tablaModificar + ";");
        } catch (SQLException e) {
            System.out.println("Error: Clase CentroSalud, método eliminarTabla para la tabla: " + tablaModificar);
            e.printStackTrace();
        }
    }

    public static String pedirTablaConVerificacion() {
        Scanner s = new Scanner(System.in);
        boolean salir;
        String tablaInsertar;
        do {
            tablaInsertar = s.nextLine();
            if (!Objects.equals(tablaInsertar, "Pacientes") && !Objects.equals(tablaInsertar, "Receta") && !Objects.equals(tablaInsertar, "Medicamentos")) {
                System.out.println("Tabla incorrecta, intentelo de nuevo");
                salir = false;
            } else salir = true;
        } while (!salir);
        return tablaInsertar;
    }

    public static void mostrarDatos(ResultSet rs) {
        try {
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                StringBuilder cadena = new StringBuilder();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    cadena.append(md.getColumnLabel(i).toUpperCase()).append(": ").append(rs.getString(md.getColumnLabel(i))).append("    ");
                }
                System.out.println(cadena);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase CentroSalud, método mostrarDatos");
            e.printStackTrace();
        }
    }
}
