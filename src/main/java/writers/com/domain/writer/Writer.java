package writers.com.domain.writer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Writer {
    private String id;
    private String name;
    private String about;
    private Integer books;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;
}
