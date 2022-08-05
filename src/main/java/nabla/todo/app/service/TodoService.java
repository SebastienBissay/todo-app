package nabla.tdo.app.service;

import java.util.List;
import java.util.Optional;
import nabla.tdo.app.model.Todo;
import nabla.tdo.app.repository.TodoRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastien Bissay
 */
@Service
public class TodoService implements ITodoService{
    
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll(Long id) {
        return this.todoRepository.findAll();
    }

    @Override
    public Todo save(Todo todo) {
        return this.todoRepository.save(todo);
    }

    @Override
    public void delete(Todo todo) {
        this.todoRepository.deleteById(todo.getId());
    }
    
}
