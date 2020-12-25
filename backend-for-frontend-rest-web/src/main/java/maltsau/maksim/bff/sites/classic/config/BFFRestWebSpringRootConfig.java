package maltsau.maksim.bff.sites.classic.config;

import com.google.common.collect.Sets;
import maltsau.maksim.bff.rest.client.equipment.config.EquipmentRestClientSpringConfig;
import maltsau.maksim.bff.rest.client.reviews.config.ReviewsRestClientSpringConfig;
import maltsau.maksim.bff.sites.classic.converter.EquipmentRatingsDtoConverter;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.util.Set;

@Configuration
@ComponentScan("maltsau.maksim.bff.sites.classic.dto,maltsau.maksim.bff.sites.classic.resource")
@Import({
        ReviewsRestClientSpringConfig.class,
        EquipmentRestClientSpringConfig.class})
@PropertySource(value = {"classpath*:app-default.properties",
        "file:///bff-config/backend-for-fontend-rest-web.properties"},
        ignoreResourceNotFound = true)
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
                new FileSystemResource("file:///bff-config/backend-for-fontend-rest-web.properties")
        );
        return propertyOverrideConfigurer;
    }
}
