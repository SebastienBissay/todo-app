package nabla.tdo.app.repository;

import nabla.tdo.app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sebastien Bissay
 */
public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
