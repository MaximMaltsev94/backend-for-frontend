package maltsau.maksim.bff.rest.client.core.config;

import org.springframework.stereotype.Component;

@Component
public class ConnectionConfig {
    private static final int DEFAULT_SOCKET_TIMEOUT = 5000;
    private static final int DEFAULT_CONNECTION_TIMEOUT = 5000;

    private int executionTimeoutMs;
    private int socketTimeoutMs;

    public ConnectionConfig() {
        executionTimeoutMs = DEFAULT_CONNECTION_TIMEOUT;
        socketTimeoutMs = DEFAULT_SOCKET_TIMEOUT;
    }

    public int getExecutionTimeoutMs() {
        return executionTimeoutMs;
    }

    public int getSocketTimeoutMs() {
        return socketTimeoutMs;
    }
}
