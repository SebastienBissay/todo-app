package nabla.todo.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Sebastien Bissay
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDate targetDate;

    public void copy(Todo todoData) {
        if (todoData.username != null) {
            this.username = todoData.username;
        }
        if (todoData.description != null) {
            this.description = todoData.description;
        }
        if (todoData.targetDate != null) {
            this.targetDate = todoData.targetDate;
        }
    }
}
