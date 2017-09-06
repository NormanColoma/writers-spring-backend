package writers.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import writers.com.model.Writer;
import writers.com.model.dto.WriterCreationDTO;
import writers.com.persistance.WriterRepository;
import writers.com.util.DTO;

import java.util.List;

@RestController
@RequestMapping("/writers")
public class WriterRestController {

    private WriterRepository writerRepository;

    public WriterRestController(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @GetMapping
    public List<Writer> getWriters() {
        return this.writerRepository.findAll();
    }

    @PostMapping
    public void addWriter(@DTO(WriterCreationDTO.class) Writer writer) {
        this.writerRepository.save(writer);
    }
}
