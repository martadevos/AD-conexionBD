package CRUD.Receta;

public class Receta {

    private int idPaciente;
    private int idMedicamento;
    private int idReceta;

    private String fechaFin;

    public Receta() {
    }

    public Receta(int idPaciente, int idMedicamento, int idReceta, String fechaFin) {
        this.idPaciente = idPaciente;
        this.idMedicamento = idMedicamento;
        this.idReceta = idReceta;
        this.fechaFin = fechaFin;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Receta:" +
                "\n IDPaciente: " + idPaciente +
                "\n IDMedicamento: " + idMedicamento +
                "\n IDReceta: " + idReceta +
                "\n Fecha fin: " + fechaFin;
    }
}
