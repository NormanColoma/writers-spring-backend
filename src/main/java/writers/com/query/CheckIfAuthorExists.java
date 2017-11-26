package writers.com.query;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import writers.com.persistance.SpringWriterRepository;

@RestController
@AllArgsConstructor
public class CheckIfAuthorExists {
    private final SpringWriterRepository springWriterRepository;

    @GetMapping(path = "/writers/existing")
    public ResponseEntity<AuthorExistsResponse> checkIfAuthorExists(@RequestParam(value="name") String name) {
        boolean exists = springWriterRepository.findFirstByNameEquals(name) != null;
        AuthorExistsResponse response = AuthorExistsResponse.builder().exists(exists).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
