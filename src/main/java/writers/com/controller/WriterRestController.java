package writers.com.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import writers.com.domain.writer.Writer;
import writers.com.domain.repository.WriterRepository;
import writers.com.persistance.SpringWriterRepository;
import writers.com.persistance.entities.WriterEntity;
import writers.com.usecase.CreateWriter;
import writers.com.usecase.RemoveWriter;
import writers.com.usecase.UpdateWriter;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/writers")
public class WriterRestController {

    private final CreateWriter createWriter;
    private final RemoveWriter removeWriter;
    private final UpdateWriter updateWriter;
    private final WriterRepository repository;

    @GetMapping
    public ResponseEntity<List<Writer>> findAll() {

        return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Writer> findOne(@PathVariable String id) {
        Optional<Writer> writerFound = repository.findOne(id);

        if(!writerFound.isPresent()) {
            return new ResponseEntity("Writer with id: " + id + " does not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(writerFound.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Writer> add(@RequestBody Writer writer) {

        return new ResponseEntity<>(this.createWriter.execute(writer), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable String id) {
        removeWriter.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Writer> update(@RequestBody Writer writer, @PathVariable String id) {
        Writer updatedWriter = updateWriter.execute(writer, id);
        return new ResponseEntity<>(updatedWriter, HttpStatus.OK);
    }
}
