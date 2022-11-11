package CRUD;

import java.io.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LeerInsertarMockaroo {
    public static void leerInsertarMockaroo(Statement st) {
        String s;
        String[] rutasFicheros = {"src/CRUD/ad2223_mdevos.Medicamentos.sql", "src/CRUD/ad2223_mdevos.Pacientes.sql", "src/CRUD/ad2223_mdevos.Receta.sql"};
        ArrayList<String> sentencias = new ArrayList<>();
        try {
            for (int i = 0; i < 3; i++) {
                BufferedReader br = new BufferedReader(new FileReader(rutasFicheros[i]));
                while ((s = br.readLine()) != null) {
                    sentencias.add(s);
                }
                br.close();
                for (String sentencia : sentencias) {
                    st.executeUpdate(sentencia);
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
