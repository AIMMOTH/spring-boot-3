package ce.mongodb;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data       // toString, equals, hashCode, getters, setters, required constructor
@Document   // Mongo DB
@NoArgsConstructor // JPA needs this
public class UserDocument {

    @Id
    private String id; // Must be named id or _id??
    @Indexed    // To sort fast
    private Instant created = Instant.now();
    private String value;
}
