package maltsau.maksim.bff.rest.client.reviews.v1;

import com.google.common.collect.Lists;
import maltsau.maksim.bff.rest.client.reviews.dto.EquipmentReview;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewRestClientImpl implements ReviewsRestClient {
    @Override
    public List<EquipmentReview> getEquipmentReviews() {
        return Lists.newArrayList(
                new EquipmentReview(1L, "user01", 5),
                new EquipmentReview(2L, "user02", 5),
                new EquipmentReview(3L, "user03", 5),
                new EquipmentReview(4L, "user04", 5),
                new EquipmentReview(5L, "user05", 5),
                new EquipmentReview(6L, "user06", 5),
                new EquipmentReview(7L, "user07", 5),
                new EquipmentReview(8L, "user08", 5),
                new EquipmentReview(9L, "user09", 5),
                new EquipmentReview(10L, "user10", 5)
        );
    }
}
