package CRUD.Receta;


import java.util.List;

public interface IRecetaDao {
    public boolean registrar(Receta receta);
    public List<Receta> listar();
    public boolean actualizar(Receta receta);
    public boolean eliminar(Receta receta);
}
