package maltsau.maksim.bff.sites.classic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("maltsau.maksim.bff.sites.classic.resource")
public class BFFRestWebSpringWebConfig {
}
