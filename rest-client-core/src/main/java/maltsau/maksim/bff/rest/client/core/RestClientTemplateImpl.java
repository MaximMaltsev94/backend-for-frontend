package maltsau.maksim.bff.rest.client.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import maltsau.maksim.bff.rest.client.core.config.ConnectionConfig;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class RestClientTemplateImpl implements RestClientTemplate {
    private String hostUrl;
    private final HttpClient httpClient;
    private final RequestConfig defaultRequestConfig;
    private ObjectMapper objectMapper;


    public RestClientTemplateImpl(ConnectionConfig connectionConfig) {
        this.httpClient = HttpClients.createDefault();
        this.defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(connectionConfig.getExecutionTimeoutMs())
                .setSocketTimeout(connectionConfig.getSocketTimeoutMs())
                .build();
        this.objectMapper = new ObjectMapper();
    }

    public <T> T get(String requestPath, Map<String, String> requestParams, Class<T> targetClass) {
        try {
            HttpResponse httpResponse = executeRequest(HttpGet.METHOD_NAME, requestPath, requestParams);
            return objectMapper.readValue(httpResponse.getEntity().getContent(), targetClass);
        } catch (IOException e) {
            throw new RestClientException("error while parsing response", e);
        }
    }

    @Override
    public <T> List<T> getList(String path, Map<String, String> params, Class<T> targetClass) {
        try {
            HttpResponse httpResponse = executeRequest(HttpGet.METHOD_NAME, path, params);
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, targetClass);
            return objectMapper.readValue(httpResponse.getEntity().getContent(), collectionType);
        } catch (IOException e) {
            throw new RestClientException("error while getting http entity", e);
        }
    }

    @Override
    public <T> Future<T> getAsync(String path, Map<String, String> params, Class<T> tClass) {
        throw new NotImplementedException("getAsync rest-client method is not implemented yet");
    }

    @Override
    public <T> Future<T> getListAsync(String path, Map<String, String> params, Class<T> targetClass) {
        return null;
    }

    private HttpResponse executeRequest(String methodName, String requestPath, Map<String, String> requestParams) {
        try {
            URIBuilder uriBuilder = new URIBuilder(hostUrl)
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

    public String getHostUrl() {
        return hostUrl;
    }

    public void setHostUrl(String hostUrl) {
        this.hostUrl = hostUrl;
    }
}
