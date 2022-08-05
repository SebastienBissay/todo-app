package nabla.todo.app.repository;

import java.util.List;
import nabla.todo.app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sebastien Bissay
 */
public interface TodoRepository extends JpaRepository<Todo, Long>{
    public List<Todo> findAllByOrderByTargetDateAsc();
}
