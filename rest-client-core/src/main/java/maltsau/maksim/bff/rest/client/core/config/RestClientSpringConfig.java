package maltsau.maksim.bff.rest.client.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan("maltsau.maksim.bff.rest.client.core")
@EnableAsync
public class RestClientSpringConfig {
}
