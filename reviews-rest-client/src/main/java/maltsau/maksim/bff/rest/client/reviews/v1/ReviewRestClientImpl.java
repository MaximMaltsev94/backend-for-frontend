package maltsau.maksim.bff.rest.client.reviews.v1;

import maltsau.maksim.bff.rest.client.core.RestClientTemplate;
import maltsau.maksim.bff.rest.client.reviews.dto.EquipmentReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

@Component
public class ReviewRestClientImpl implements ReviewsRestClient {

    private RestClientTemplate restClientTemplate;

    @Autowired
    @Qualifier("reviewRestClientTemplate")
    public void setRestClientTemplate(RestClientTemplate restClientTemplate) {
        this.restClientTemplate = restClientTemplate;
    }

    @Override
    public Future<List<EquipmentReview>> getEquipmentReviewsAsync() {
        return restClientTemplate.getListAsync("/api/reviews/v1/", Collections.emptyMap(),
                EquipmentReview.class);
    }
}
