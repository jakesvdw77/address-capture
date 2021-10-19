package address.capture.configs;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
public class GenericConfig
{
    @Bean
    public ModelMapper modelMapper() {


        Converter<Instant, Long> instantToLong = new Converter<>() {
            public Long convert(MappingContext<Instant, Long> context) {
                return context.getSource() == null ? null : context.getSource().toEpochMilli();
            }
        };

        var modelMapper = new ModelMapper();
        modelMapper.addConverter(instantToLong);
        return modelMapper;

    }

}
