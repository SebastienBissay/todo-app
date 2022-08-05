package nabla.tdo.app.service;

import java.util.List;
import java.util.Optional;
import nabla.tdo.app.model.Todo;

/**
 *
 * @author Sebastien Bissay
 */
public interface ITodoService {
    public List<Todo> findAll(Long id);
    
    public Todo save(Todo todo);
    
    public void delete(Todo todo);
}
