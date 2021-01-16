package maltsau.maksim.bff.rest.client.core.reactive;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import io.netty.handler.codec.http.HttpMethod;
import maltsau.maksim.bff.rest.client.core.RestClientException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import reactor.netty.http.client.HttpClient;

import java.util.List;
import java.util.Map;

public class ReactiveRestClientTemplateImpl implements ReactiveRestClientTemplate {

    private String hostUrl;
    private ObjectMapper objectMapper;
    private UriBuilderFactory uriBuilderFactory;

    public ReactiveRestClientTemplateImpl() {
        this.objectMapper = new ObjectMapper();
        uriBuilderFactory = new DefaultUriBuilderFactory();
    }

    @Override
    public <T> Mono<T> get(String path, Map<String, String> params, Class<T> targetClass) {
        return executeRequest(HttpMethod.GET.name(), path, params)
                .aggregate()
                .asString()
                .map(responseString -> {
                    try {
                        return new ObjectMapper().readValue(responseString, targetClass);
                    } catch (JsonProcessingException e) {
                        throw new RestClientException("error while deserialising response", e);
                    }
                });
    }

    @Override
    public <T> Mono<List<T>> getList(String path, Map<String, String> params, Class<T> targetClass) {
        return executeRequest(HttpMethod.GET.name(), path, params)
                .aggregate()
                .asString()
                .map(responseString -> {
                    try {
                        CollectionType collectionType = objectMapper.getTypeFactory()
                                .constructCollectionType(List.class, targetClass);
                        return objectMapper.readValue(responseString, collectionType);
                    } catch (JsonProcessingException e) {
                        throw new RestClientException("error while deserialising response", e);
                    }
                });
    }

    private ByteBufFlux executeRequest(String methodName, String requestPath, Map<String, String> requestParams) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        requestParams.forEach(queryParams::add);

        String requestUri = uriBuilderFactory
                .uriString(hostUrl)
                .path(requestPath)
                .queryParams(queryParams)
                .build()
                .toString();

        return HttpClient.create()
                .baseUrl(requestUri)
                .get()
                .responseContent();
    }

    public void setHostUrl(String hostUrl) {
        this.hostUrl = hostUrl;
    }
}
