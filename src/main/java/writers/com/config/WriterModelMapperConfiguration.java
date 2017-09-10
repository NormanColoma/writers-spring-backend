package writers.com.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import writers.com.domain.Writer;
import writers.com.persistance.entities.WriterEntity;

@Configuration
public class WriterModelMapperConfiguration {

    @Bean
    public ModelMapper ModelMapperConfiguration() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapping(modelMapper);

        return modelMapper;
    }

    private void  modelMapping(ModelMapper modelMapper) {
        modelMapper
                .createTypeMap(Writer.class, WriterEntity.class);
    }
}
