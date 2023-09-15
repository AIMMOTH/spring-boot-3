package ce.mariadb;

//import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Create in MariaDB:
 * > create table row_entity (id int auto_increment, value longtext, primary key (id));
 */
@AllArgsConstructor // To use builder
@Builder    // Creates .builder() method
@Data       // toString, equals, hashCode, getter, setters, required constructors
@Entity     // JPA (this is an entity class)
@NoArgsConstructor  // JPA needs this
@Table      // JPA (settings for table)
public class RowEntity {

    @Id
    @org.springframework.data.annotation.Id // https://stackoverflow.com/a/71108640
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String value;
}
