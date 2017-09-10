package writers.com.domain;

import java.util.List;

public interface WriterRepository {
    Writer create(Writer writer);
    List<Writer> findAll();
}
