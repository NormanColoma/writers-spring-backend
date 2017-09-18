package writers.com.persistance;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import writers.com.domain.writer.Writer;
import writers.com.domain.writer.WriterRepository;
import writers.com.persistance.entities.WriterEntity;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class WriterMongoRepository implements WriterRepository {

    private final SpringWriterRepository repository;
    private final ModelMapper modelMapper;

    public WriterMongoRepository(SpringWriterRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Writer create(Writer writer) {
        WriterEntity entity = this.modelMapper.map(writer, WriterEntity.class);

        this.repository.save(entity);

        writer.setId(entity.getId());

        return  writer;
    }

    @Override
    public List<Writer> findAll() {
        Type listType = new TypeToken<List<Writer>>() {}.getType();
        List<Writer> writers = this.modelMapper.map(this.repository.findAll(), listType);

        return writers;
    }

    @Override
    public void removeWriter(String id) {
        repository.delete(id);
    }
}

@Repository
interface SpringWriterRepository extends MongoRepository<WriterEntity, String> { }
