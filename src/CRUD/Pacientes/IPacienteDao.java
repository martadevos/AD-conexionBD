package CRUD.Pacientes;

import java.util.List;

public interface IPacienteDao {
    public boolean registrar(Paciente paciente);
    public List<Paciente> listar();
    public boolean actualizar(Paciente paciente);
    public boolean eliminar(Paciente paciente);
}
