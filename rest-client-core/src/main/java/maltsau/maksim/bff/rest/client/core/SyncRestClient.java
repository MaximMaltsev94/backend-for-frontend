package maltsau.maksim.bff.rest.client.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import maltsau.maksim.bff.rest.client.core.config.ConnectionConfig;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

public abstract class SyncRestClient {
    private String hostUrl;
    private final HttpClient httpClient;
    private final RequestConfig defaultRequestConfig;
    private ObjectMapper objectMapper;


    @Autowired
    public SyncRestClient(ConnectionConfig connectionConfig) {
        this.httpClient = HttpClients.createDefault();
        this.defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(connectionConfig.getExecutionTimeoutMs())
                .setSocketTimeout(connectionConfig.getSocketTimeoutMs())
                .build();
        this.objectMapper = new ObjectMapper();
    }

    public <T> T get(String requestPath, Map<String, String> requestParams, Class<T> targetClass) throws IOException {
        HttpResponse httpResponse = executeRequest(HttpGet.METHOD_NAME, requestPath, requestParams);
        return objectMapper.readValue(httpResponse.getEntity().getContent(), targetClass);
    }

    private HttpResponse executeRequest(String methodName, String requestPath, Map<String, String> requestParams) {
        try {
            URIBuilder uriBuilder = new URIBuilder()
                    .setHost(hostUrl)
                    .setPath(requestPath);

            HttpRequestBase httpRequest;

            if ("GET".equals(methodName)) {
                httpRequest = new HttpGet(uriBuilder.build());
            } else {
                throw new UnsupportedOperationException(String.format("http method %s invalid or not implemented yet", methodName));
            }
            httpRequest.setConfig(defaultRequestConfig);
            return httpClient.execute(httpRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String getHostUrl() {
        return hostUrl;
    }

    protected void setHostUrl(String hostUrl) {
        this.hostUrl = hostUrl;
    }
}
