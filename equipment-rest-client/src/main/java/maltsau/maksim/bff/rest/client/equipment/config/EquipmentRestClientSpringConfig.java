package maltsau.maksim.bff.rest.client.equipment.config;

import maltsau.maksim.bff.rest.client.core.RestClientTemplate;
import maltsau.maksim.bff.rest.client.core.config.RestClientSpringConfig;
import maltsau.maksim.bff.rest.client.core.config.RestClientTemplateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("maltsau.maksim.bff.rest.client.equipment")
@Import(RestClientSpringConfig.class)
public class EquipmentRestClientSpringConfig {
    @Bean("equipmentRestClientTemplate")
    public RestClientTemplate equipmentRestClientTemplate(RestClientTemplateFactory restClientTemplateFactory) {
        return restClientTemplateFactory.getRestClientTemplate();
    }
}
