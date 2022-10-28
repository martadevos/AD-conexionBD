package CRUD.Medicamentos;

public class Medicamento {

    private int idMedicamento;

    private String composicion;

    public Medicamento() {
    }

    public Medicamento(int idPaciente, String composicion) {
        this.idMedicamento = idPaciente;
        this.composicion = composicion;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getComposicion() {
        return composicion;
    }

    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }

    @Override
    public String toString() {
        return "Medicamento:" +
                "\n ID=" + idMedicamento +
                "\n Composicion: " + composicion;
    }
}
