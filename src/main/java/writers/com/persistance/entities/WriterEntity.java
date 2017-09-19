package writers.com.persistance.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

@Document(collection = "writer")
@Data
public class WriterEntity {

    @Id
    private String id;
    private String name;
    private String about;
    private Integer books;
    @CreatedDate
    private Date created_at;
}
