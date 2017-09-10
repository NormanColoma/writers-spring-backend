package writers.com.resources;

import org.springframework.web.bind.annotation.*;
import writers.com.domain.Writer;
import writers.com.domain.WriterRepository;

import java.util.List;

@RestController
@RequestMapping("/writers")
public class WriterResource {

    private WriterRepository repository;

    public WriterResource(WriterRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Writer> findAll() {
        return this.repository.findAll();
    }

    @PostMapping
    public Writer add(@RequestBody Writer writer) {
        return this.repository.create(writer);
    }
}
