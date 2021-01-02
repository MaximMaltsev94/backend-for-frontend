package maltsau.maksim.bff.rest.client.reviews.v1;

import maltsau.maksim.bff.rest.client.core.RestClientTemplate;
import maltsau.maksim.bff.rest.client.reviews.dto.EquipmentReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ReviewRestClientImpl implements ReviewsRestClient {

    private RestClientTemplate restClientTemplate;

    @Autowired
    @Qualifier("reviewRestClientTemplate")
    public void setRestClientTemplate(RestClientTemplate restClientTemplate) {
        this.restClientTemplate = restClientTemplate;
    }

    @Override
    public List<EquipmentReview> getEquipmentReviews() {
        return restClientTemplate.getList("/api/equipmentreviews/v1/", Collections.emptyMap(),
                EquipmentReview.class);
    }
}
