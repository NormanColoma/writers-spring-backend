package writers.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class WritersApplication {

	public static void main(String[] args) {
		SpringApplication.run(WritersApplication.class, args);
	}
}
