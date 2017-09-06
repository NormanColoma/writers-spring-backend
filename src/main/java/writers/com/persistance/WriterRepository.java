package writers.com.persistance;

import org.springframework.data.mongodb.repository.MongoRepository;
import writers.com.model.Writer;

import java.util.UUID;

public interface WriterRepository extends MongoRepository<Writer, UUID> {
}
