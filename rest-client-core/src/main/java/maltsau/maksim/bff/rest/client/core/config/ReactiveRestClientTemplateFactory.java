package maltsau.maksim.bff.rest.client.core.config;

import maltsau.maksim.bff.rest.client.core.reactive.ReactiveRestClientTemplateImpl;
import maltsau.maksim.bff.rest.client.core.reactive.ReactiveRestClientTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReactiveRestClientTemplateFactory {
    public ReactiveRestClientTemplate getRestClientTemplate() {
        return new ReactiveRestClientTemplateImpl();
    }
}
