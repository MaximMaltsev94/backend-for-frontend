package maltsau.maksim.bff.sites.reactive.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import maltsau.maksim.bff.rest.client.equipment.config.EquipmentRestClientSpringConfig;
import maltsau.maksim.bff.rest.client.reviews.config.ReviewsRestClientSpringConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
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

    @Bean
    public MongoClient mongoClient(@Value("${mongodb.connectionString}") String mongodbConnectionString) {
        return MongoClients.create(mongodbConnectionString);
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient) {
        return new ReactiveMongoTemplate(mongoClient, "equipment");
    }
}
