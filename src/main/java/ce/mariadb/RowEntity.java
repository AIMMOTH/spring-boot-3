package ce.mariadb;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor // To use builder
@Builder    // Creates .builder() method
@Data       // toString, equals, hashCode, getter, setters, required constructors
@Entity     // JPA (this is an entity class)
@NoArgsConstructor  // JPA needs this
@Table      // JPA (settings for table)
public class RowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String value;
}
