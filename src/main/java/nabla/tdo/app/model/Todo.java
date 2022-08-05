package nabla.tdo.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
}
