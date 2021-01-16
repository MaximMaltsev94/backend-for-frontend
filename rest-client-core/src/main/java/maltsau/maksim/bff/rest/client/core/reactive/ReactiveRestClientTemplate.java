package maltsau.maksim.bff.rest.client.core.reactive;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public interface ReactiveRestClientTemplate {
    <T> Mono<T> get(String path, Map<String, String> params, Class<T> targetClass);
    <T> Mono<List<T>> getList(String path, Map<String, String> params, Class<T> targetClass);
}
