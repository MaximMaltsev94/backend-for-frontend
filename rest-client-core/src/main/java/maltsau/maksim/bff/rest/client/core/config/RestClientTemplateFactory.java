package maltsau.maksim.bff.rest.client.core.config;

import maltsau.maksim.bff.rest.client.core.RestClientTemplate;
import maltsau.maksim.bff.rest.client.core.RestClientTemplateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestClientTemplateFactory {
    private ConnectionConfig connectionConfig;

    @Autowired
    public void setConnectionConfig(ConnectionConfig connectionConfig) {
        this.connectionConfig = connectionConfig;
    }

    public RestClientTemplate getRestClientTemplate() {
        return new RestClientTemplateImpl(connectionConfig);
    }
}
