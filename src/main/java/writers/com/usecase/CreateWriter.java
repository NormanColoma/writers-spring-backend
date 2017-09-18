package writers.com.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import writers.com.domain.writer.Writer;
import writers.com.domain.writer.WriterRepository;

@Component
@AllArgsConstructor
public class CreateWriter {

    private final WriterRepository writerRepository;

    public Writer execute(Writer writer) {
        return this.writerRepository.create(writer);
    }
}
