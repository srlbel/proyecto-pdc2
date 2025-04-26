public interface IController<T> {
    List<T> getAll();        // Obtener todos los elementos
    T getById(int id);       // Obtener un elemento por su ID
    T create(T entity);       // Crear un nuevo elemento
    T update(int id, T entity); // Actualizar un elemento existente
    boolean delete(int id);  // Eliminar un elemento por su ID
}
