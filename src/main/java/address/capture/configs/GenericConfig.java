package address.capture.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericConfig {
    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

}
