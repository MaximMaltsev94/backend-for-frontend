package maltsau.maksim.bff.sites.classic.resource;


import com.google.common.collect.Lists;
import maltsau.maksim.bff.rest.client.equipment.v1.EquipmentRestClient;
import maltsau.maksim.bff.rest.client.reviews.v1.ReviewsRestClient;
import maltsau.maksim.bff.sites.classic.dto.EquipmentRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reviewaggregator/v1/equipmentreviews/",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewAggregatorResourceV1 {


    private ReviewsRestClient reviewsRestClient;

    private EquipmentRestClient equipmentRestClient;

    @Autowired
    public ReviewAggregatorResourceV1(ReviewsRestClient reviewsRestClient, EquipmentRestClient equipmentRestClient) {
        this.reviewsRestClient = reviewsRestClient;
        this.equipmentRestClient = equipmentRestClient;
    }

    @GetMapping("/pages/{pageNum}/")
    public List<EquipmentRatings> getPage(@PathVariable("pageNum") Integer pageNum) {
        var i = 10;
        return Lists.newArrayList(new EquipmentRatings(12L));
    }
}
