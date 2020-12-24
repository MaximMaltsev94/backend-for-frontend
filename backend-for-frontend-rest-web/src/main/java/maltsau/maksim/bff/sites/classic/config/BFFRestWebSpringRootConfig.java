package maltsau.maksim.bff.sites.classic.config;

import maltsau.maksim.bff.rest.client.equipment.config.EquipmentRestClientSpringConfig;
import maltsau.maksim.bff.rest.client.reviews.config.ReviewsRestClientSpringConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("maltsau.maksim.bff.sites.classic.dto,maltsau.maksim.bff.sites.classic.resource")
@Import({
        ReviewsRestClientSpringConfig.class,
        EquipmentRestClientSpringConfig.class})
public class BFFRestWebSpringRootConfig {
}
