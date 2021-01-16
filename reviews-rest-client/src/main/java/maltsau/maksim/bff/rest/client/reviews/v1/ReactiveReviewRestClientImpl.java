package maltsau.maksim.bff.rest.client.reviews.v1;

import maltsau.maksim.bff.rest.client.core.reactive.ReactiveRestClientTemplate;
import maltsau.maksim.bff.rest.client.reviews.dto.EquipmentReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Component
public class ReactiveReviewRestClientImpl implements ReactiveReviewRestClient {

    private ReactiveRestClientTemplate reactiveReviewRestClientTemplate;


    @Autowired
    @Qualifier("reactiveReviewRestClientTemplate")
    public void setReactiveReviewRestClient(ReactiveRestClientTemplate reactiveReviewRestClientTemplate) {
        this.reactiveReviewRestClientTemplate = reactiveReviewRestClientTemplate;
    }

    @Override
    public Mono<List<EquipmentReview>> getEquipmentReviews() {
        return reactiveReviewRestClientTemplate.getList("/api/reviews/v1/", Collections.emptyMap(), EquipmentReview.class);
    }
}
