package maltsau.maksim.bff.sites.classic.config;

import com.google.common.collect.Sets;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import maltsau.maksim.bff.rest.client.equipment.config.EquipmentRestClientSpringConfig;
import maltsau.maksim.bff.rest.client.reviews.config.ReviewsRestClientSpringConfig;
import maltsau.maksim.bff.sites.classic.converter.EquipmentRatingsDtoConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Set;

@Configuration
@ComponentScan(basePackages = {
        "maltsau.maksim.bff.sites.classic.dto",
        "maltsau.maksim.bff.sites.classic.resource",
        "maltsau.maksim.bff.sites.classic.repository",
        "maltsau.maksim.bff.sites.classic.service",
        "maltsau.maksim.bff.sites.classic.aop"})
@Import({
        ReviewsRestClientSpringConfig.class,
        EquipmentRestClientSpringConfig.class})
@PropertySources({
        @PropertySource("classpath:app-default.properties"),
        @PropertySource(value = "file:/bff-config/backend-for-frontend-rest-web.properties",
                ignoreResourceNotFound = true)
})
public class BFFRestWebSpringRootConfig {

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    private Set<Converter<?, ?>> getConverters() {
        return Sets.newHashSet(
                new EquipmentRatingsDtoConverter()
        );
    }

    @Bean
    public PropertyOverrideConfigurer propertyOverrideConfigurer() {
        PropertyOverrideConfigurer propertyOverrideConfigurer = new PropertyOverrideConfigurer();
        propertyOverrideConfigurer.setIgnoreInvalidKeys(true);
        propertyOverrideConfigurer.setIgnoreResourceNotFound(true);
        propertyOverrideConfigurer.setLocations(
                new ClassPathResource("app-default.properties"),
                new FileSystemResource("/bff-config/backend-for-frontend-rest-web.properties")
        );
        return propertyOverrideConfigurer;
    }

    @Bean
    public MongoClient mongoClient(@Value("${mongodb.connectionString}") String mongodbConnectionString) {
        return MongoClients.create(mongodbConnectionString);
    }


    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "equipment");
    }
}
