package maltsau.maksim.bff.rest.client.reviews.v1;

import maltsau.maksim.bff.rest.client.reviews.dto.EquipmentReview;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ReactiveReviewRestClient {
    Mono<List<EquipmentReview>> getEquipmentReviews();
}
