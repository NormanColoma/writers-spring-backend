package writers.com.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class WriterCreationDTO {
    private String name;
    private String about;
    private Integer books;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private final LocalDateTime editedAt = LocalDateTime.now();
}
