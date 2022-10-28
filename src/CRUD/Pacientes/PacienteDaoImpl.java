package CRUD.Pacientes;

import CRUD.CentroSalud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoImpl implements IPacienteDao {
    @Override
    public boolean registrar(Paciente paciente) {
        boolean registrar = false;

        Statement stm;
        Connection con;

        String sql = "INSERT INTO Pacientes values ('" + paciente.getNombre() + "','" + paciente.getApellidos() + "','" + paciente.getNss() + "');";

        try {
            con = CentroSalud.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase PacienteDaoImpl, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<Paciente> listar() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql="SELECT * FROM Pacientes ORDER BY idPaciente";

        List<Paciente> listaPaciente= new ArrayList<>();

        try {
            con= CentroSalud.conectar();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Paciente paciente=new Paciente();
                paciente.setIdPaciente(rs.getInt(1));
                paciente.setNombre(rs.getString(2));
                paciente.setApellidos(rs.getString(3));
                paciente.setNss(rs.getString(4));
                listaPaciente.add(paciente);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase PacienteDaoImpl, método obtener");
            e.printStackTrace();
        }

        return listaPaciente;
    }

    @Override
    public boolean actualizar(Paciente paciente) {
        Connection con;
        Statement stm;

        boolean actualizar=false;

        String sql="UPDATE Pacientes SET nombre='"+paciente.getNombre()+"', apellidos='"+paciente.getApellidos()+"', nss='"+paciente.getNss()+"'" +" WHERE idPaciente="+paciente.getIdPaciente();
        try {
            con=CentroSalud.conectar();
            stm=con.createStatement();
            stm.execute(sql);
            actualizar=true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase PacienteDaoImpl, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Paciente paciente) {
        Connection con;
        Statement stm;

        boolean eliminar=false;

        String sql="DELETE FROM Pacientes WHERE idPaciente="+paciente.getIdPaciente();
        try {
            con=CentroSalud.conectar();
            stm=con.createStatement();
            stm.execute(sql);
            eliminar=true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase PacienteDaoImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }
}
