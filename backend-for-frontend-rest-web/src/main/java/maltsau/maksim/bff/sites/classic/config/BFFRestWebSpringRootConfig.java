package maltsau.maksim.bff.sites.classic.config;

import com.google.common.collect.Sets;
import maltsau.maksim.bff.rest.client.equipment.config.EquipmentRestClientSpringConfig;
import maltsau.maksim.bff.rest.client.reviews.config.ReviewsRestClientSpringConfig;
import maltsau.maksim.bff.sites.classic.converter.EquipmentRatingsDtoConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.Set;

@Configuration
@ComponentScan("maltsau.maksim.bff.sites.classic.dto,maltsau.maksim.bff.sites.classic.resource")
@Import({
        ReviewsRestClientSpringConfig.class,
        EquipmentRestClientSpringConfig.class})
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
}
