package writers.com.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import writers.com.domain.writer.Writer;
import writers.com.domain.writer.WriterRepository;
import writers.com.usecase.CreateWriter;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/writers")
public class WriterRestController {

    private CreateWriter createWriter;
    private WriterRepository repository;

    @GetMapping
    public ResponseEntity<List<Writer>> findAll() {

        return new ResponseEntity<List<Writer>>(this.repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Writer> add(@RequestBody Writer writer) {

        return new ResponseEntity<>(this.createWriter.execute(writer), HttpStatus.CREATED);
    }
}
