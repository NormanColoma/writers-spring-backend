package writers.com.domain.writer;

import writers.com.domain.writer.Writer;

import java.util.List;

public interface WriterRepository {
    Writer create(Writer writer);
    List<Writer> findAll();
    void removeWriter(String id);
}
