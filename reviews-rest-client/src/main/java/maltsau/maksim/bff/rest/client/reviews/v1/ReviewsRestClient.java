package maltsau.maksim.bff.rest.client.reviews.v1;

import maltsau.maksim.bff.rest.client.reviews.dto.EquipmentReview;

import java.util.List;
import java.util.concurrent.Future;

public interface ReviewsRestClient {
    Future<List<EquipmentReview>> getEquipmentReviewsAsync();
}
