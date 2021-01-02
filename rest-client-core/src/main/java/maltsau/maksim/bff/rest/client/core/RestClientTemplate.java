package maltsau.maksim.bff.rest.client.core;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public interface RestClientTemplate {
    <T> T get(String path, Map<String, String> params, Class<T> targetClass);
    <T> List<T> getList(String path, Map<String, String> params, Class<T> targetClass);

    <T> Future<T> getAsync(String path, Map<String, String> params, Class<T> targetClass);
    <T> Future<T> getListAsync(String path, Map<String, String> params, Class<T> targetClass);
}
