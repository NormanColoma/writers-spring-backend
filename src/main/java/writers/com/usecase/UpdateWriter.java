package writers.com.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import writers.com.domain.writer.Writer;
import writers.com.domain.writer.WriterRepository;

@Component
@AllArgsConstructor
public class UpdateWriter {

    private WriterRepository repository;

    public Writer execute(Writer writer, String writerId) {
        return repository.update(writer, writerId);
    }
}
