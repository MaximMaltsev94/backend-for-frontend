package maltsau.maksim.bff.sites.classic.resource;

import maltsau.maksim.bff.sites.classic.aop.ExecutionTimeLoggable;
import maltsau.maksim.bff.sites.classic.service.RandomStringService;
import maltsau.maksim.bff.sites.classic.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Sorted random string resource.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/20/2021
 *
 * @author Maksim Maltsau
 */
@RestController
@RequestMapping(value = "/sorted-random-string/v1/",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SortedRandomStringResource {

    private static final int DEFAULT_STRING_LENGTH = 25_000;

    private final RandomStringService randomStringService;

    private final SortService sortService;

    @Autowired
    public SortedRandomStringResource(RandomStringService randomStringService,
                                      SortService sortService) {
        this.randomStringService = randomStringService;
        this.sortService = sortService;
    }

    @GetMapping("/{length}")
    @ExecutionTimeLoggable
    public Map<String, String> getRandomString(@PathVariable int length) {
        return Map.of("sortedString", sortService.sortString(randomStringService.getRandomString(length)));
    }
}
