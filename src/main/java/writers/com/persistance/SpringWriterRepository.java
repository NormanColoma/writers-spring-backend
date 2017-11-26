package writers.com.persistance;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import writers.com.persistance.entities.WriterEntity;

@Repository
public interface SpringWriterRepository extends MongoRepository<WriterEntity, String> {

    WriterEntity findFirstByNameEquals(String authorName);
}

