package maltsau.maksim.bff.rest.client.reviews.v1;

import maltsau.maksim.bff.rest.client.reviews.dto.EquipmentReview;

import java.util.List;

public interface ReviewsRestClient {
    List<EquipmentReview> getEquipmentReviews();
}
