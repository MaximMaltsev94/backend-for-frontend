package maltsau.maksim.bff.rest.client.reviews.config;

import maltsau.maksim.bff.rest.client.core.RestClientTemplate;
import maltsau.maksim.bff.rest.client.core.config.ReactiveRestClientTemplateFactory;
import maltsau.maksim.bff.rest.client.core.config.RestClientSpringConfig;
import maltsau.maksim.bff.rest.client.core.config.RestClientTemplateFactory;
import maltsau.maksim.bff.rest.client.core.reactive.ReactiveRestClientTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("maltsau.maksim.bff.rest.client.reviews")
@Import(RestClientSpringConfig.class)
public class ReviewsRestClientSpringConfig {
    @Bean("reviewRestClientTemplate")
    public RestClientTemplate reviewRestClientTemplate(RestClientTemplateFactory restClientTemplateFactory) {
        return restClientTemplateFactory.getRestClientTemplate();
    }

    @Bean("reactiveReviewRestClientTemplate")
    public ReactiveRestClientTemplate reactiveReviewRestClientTemplate(ReactiveRestClientTemplateFactory reactiveRestClientTemplateFactory) {
        return reactiveRestClientTemplateFactory.getRestClientTemplate();
    }
}
