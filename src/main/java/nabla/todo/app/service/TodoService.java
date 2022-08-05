package nabla.todo.app.service;

import java.util.List;
import nabla.todo.app.model.Todo;
import nabla.todo.app.repository.TodoRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastien Bissay
 */
@Service
public class TodoService implements ITodoService{
    
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return this.todoRepository.findAllByOrderByTargetDateAsc();
    }

    @Override
    public Todo findById(Long id) {
        return this.todoRepository.findById(id).orElse(null);
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
