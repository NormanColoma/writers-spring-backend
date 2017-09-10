package writers.com.persistance.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "writer")
@Data
public class WriterEntity {

    @Id
    private String id;
    private String name;
    private String about;
    private Integer books;
}
