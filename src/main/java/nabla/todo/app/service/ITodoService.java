package nabla.todo.app.service;

import java.util.List;
import nabla.todo.app.model.Todo;

/**
 *
 * @author Sebastien Bissay
 */
public interface ITodoService {
    public List<Todo> findAll();
    
    public Todo findById(Long id);
    
    public Todo save(Todo todo);
    
    public void delete(Long id);
}
