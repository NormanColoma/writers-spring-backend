package writers.com.domain.repository;

import writers.com.domain.writer.Writer;

import java.util.List;
import java.util.Optional;

public interface WriterRepository {
    Writer create(Writer writer);
    List<Writer> findAll();
    void remove(String id);
    Writer update(Writer writer, String id);
    Optional<Writer> findOne(String id);
}
