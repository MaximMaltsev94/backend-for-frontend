package maltsau.maksim.bff.sites.classic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Random string service.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/20/2021
 *
 * @author Maksim Maltsau
 */
@Service
public class RandomStringService {

    private static final int LEFT_LIMIT = 48; // numeral '0'
    private static final int RIGHT_LIMIT = 122; // letter 'z'

    private final Random random;

    @Autowired
    public RandomStringService(Random random) {
        this.random = random;
    }

    public String getRandomString(int targetLength) {
        return random.ints(LEFT_LIMIT, RIGHT_LIMIT + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
