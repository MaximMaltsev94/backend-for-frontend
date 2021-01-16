package maltsau.maksim.bff.sites.reactive.config;

import maltsau.maksim.bff.rest.client.equipment.config.EquipmentRestClientSpringConfig;
import maltsau.maksim.bff.rest.client.reviews.config.ReviewsRestClientSpringConfig;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebFlux
@Import({ReviewsRestClientSpringConfig.class, EquipmentRestClientSpringConfig.class})
public class WebFluxConfig {
    @Bean
    public PropertyOverrideConfigurer propertyOverrideConfigurer() {
        PropertyOverrideConfigurer propertyOverrideConfigurer = new PropertyOverrideConfigurer();
        propertyOverrideConfigurer.setLocation(new ClassPathResource("app-default.properties"));
        propertyOverrideConfigurer.setIgnoreInvalidKeys(true);
        propertyOverrideConfigurer.setIgnoreResourceNotFound(true);
        return propertyOverrideConfigurer;
    }
}
