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
                new EquipmentReview(1L, 1L, "user01", 5),
                new EquipmentReview(2L,2L, "user02", 5),
                new EquipmentReview(3L,3L, "user03", 5),
                new EquipmentReview(4L,4L, "user04", 5),
                new EquipmentReview(5L,5L, "user05", 5),

                new EquipmentReview(6L,1L, "user06", 1),
                new EquipmentReview(7L,2L, "user07", 2),
                new EquipmentReview(8L,3L, "user08", 3),
                new EquipmentReview(9L,4L, "user09", 4),
                new EquipmentReview(10L, 5L,"user10", 5)
        );
    }
}
