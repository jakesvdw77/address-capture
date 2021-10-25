package address.capture.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    /**
     * Bean to configure OPI API Swagger documents
     *
     * @param applicationName
     * @param applicationDescription
     * @param appVersion
     * @return
     */
    @Bean
    public OpenAPI customOpenAPI(
            @Value("${application.name}") String applicationName,
            @Value("${application-description}") String applicationDescription,
            @Value("${application-version}") String appVersion,
            @Value("${application.licence.url}") String licence) {

        return new OpenAPI()
                .info(new Info()
                        .title(applicationName)
                        .description(applicationDescription)
                        .version(appVersion)
                        .termsOfService(licence)
                        .license(new License().name("Apache 2.0").url(licence)));
    }
}
