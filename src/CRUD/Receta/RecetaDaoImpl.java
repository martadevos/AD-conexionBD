package CRUD.Receta;

import CRUD.CentroSalud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecetaDaoImpl implements IRecetaDao{
    @Override
    public boolean registrar(Receta receta) {
        boolean registrar = false;

        Statement stm;
        Connection con;

        String sql = "INSERT INTO Receta values (" + receta.getIdMedicamento() + "," + receta.getIdPaciente() + ",'" + receta.getFechaFin() + "');";

        try {
            con = CentroSalud.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase RecetaDaoImpl, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<Receta> listar() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql="SELECT * FROM Receta ORDER BY idReceta";

        List<Receta> listaReceta= new ArrayList<>();

        try {
            con= CentroSalud.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Receta receta=new Receta();
                receta.setIdMedicamento(rs.getInt(1));
                receta.setIdReceta(rs.getInt(2));
                receta.setIdPaciente(rs.getInt(3));
                receta.setFechaFin(rs.getString(4));
                listaReceta.add(receta);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase RecetaDaoImpl, método obtener");
            e.printStackTrace();
        }

        return listaReceta;
    }

    @Override
    public boolean actualizar(Receta receta) {
        Connection con;
        Statement stm;

        boolean actualizar=false;

        String sql="UPDATE Receta SET idMedicamento='"+receta.getIdMedicamento()+"', idPaciente='"+receta.getIdPaciente()+"', fechaFin='"+receta.getFechaFin()+"'" +" WHERE idReceta="+receta.getIdReceta();
        try {
            con=CentroSalud.conectar();
            stm=con.createStatement();
            stm.execute(sql);
            actualizar=true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase RecetaDaoImpl, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Receta receta) {
        Connection con;
        Statement stm;

        boolean eliminar=false;

        String sql="DELETE FROM Receta WHERE idReceta="+receta.getIdReceta();
        try {
            con=CentroSalud.conectar();
            stm=con.createStatement();
            stm.execute(sql);
            eliminar=true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase RecetaDaoImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }
}
