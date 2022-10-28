package CRUD.Medicamentos;

import CRUD.Pacientes.Paciente;

import java.util.List;

public interface IMedicamentoDao {
    public boolean registrar(Medicamento medicamento);
    public List<Medicamento> listar();
    public boolean actualizar(Medicamento medicamento);
    public boolean eliminar(Medicamento medicamento);
}
