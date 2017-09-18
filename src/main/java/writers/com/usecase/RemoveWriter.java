package writers.com.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import writers.com.persistance.WriterMongoRepository;

@Component
@AllArgsConstructor
public class RemoveWriter {
    private WriterMongoRepository repository;

    public void execute(String writerId) {
        repository.remove(writerId);
    }
}
