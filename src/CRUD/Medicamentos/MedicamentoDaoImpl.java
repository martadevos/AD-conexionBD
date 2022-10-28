package CRUD.Medicamentos;

import CRUD.CentroSalud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDaoImpl implements IMedicamentoDao{
    @Override
    public boolean registrar(Medicamento medicamento) {
        boolean registrar = false;

        Statement stm;
        Connection con;

        String sql = "INSERT INTO Medicamentos values ('" + medicamento.getNombre() + "','" + medicamento.getApellidos() + "','" + medicamento.getNss() + "');";

        try {
            con = CentroSalud.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase MedicamentoDaoImpl, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<Medicamento> listar() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql="SELECT * FROM Medicamentos ORDER BY idPaciente";

        List<Medicamento> listaMedicamento= new ArrayList<>();

        try {
            con= CentroSalud.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Medicamento medicamento=new Medicamento();
                medicamento.setIdPaciente(rs.getInt(1));
                medicamento.setNombre(rs.getString(2));
                medicamento.setApellidos(rs.getString(3));
                medicamento.setNss(rs.getString(4));
                listaMedicamento.add(medicamento);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase MedicamentoDaoImpl, método obtener");
            e.printStackTrace();
        }

        return listaMedicamento;
    }

    @Override
    public boolean actualizar(Medicamento medicamento) {
        Connection con;
        Statement stm;

        boolean actualizar=false;

        String sql="UPDATE Medicamentos SET nombre='"+medicamento.getNombre()+"', apellidos='"+medicamento.getApellidos()+"', nss='"+medicamento.getNss()+"'" +" WHERE idPaciente="+medicamento.getIdPaciente();
        try {
            con=CentroSalud.conectar();
            stm=con.createStatement();
            stm.execute(sql);
            actualizar=true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase MedicamentoDaoImpl, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Medicamento medicamento) {
        Connection con;
        Statement stm;

        boolean eliminar=false;

        String sql="DELETE FROM Medicamentos WHERE idPaciente="+medicamento.getIdPaciente();
        try {
            con=CentroSalud.conectar();
            stm=con.createStatement();
            stm.execute(sql);
            eliminar=true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase MedicamentoDaoImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }
}
