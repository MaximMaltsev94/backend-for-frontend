package maltsau.maksim.bff.sites.classic.resource;


import com.google.common.util.concurrent.Futures;
import maltsau.maksim.bff.rest.client.equipment.dto.Equipment;
import maltsau.maksim.bff.rest.client.equipment.v1.EquipmentRestClient;
import maltsau.maksim.bff.rest.client.reviews.dto.EquipmentReview;
import maltsau.maksim.bff.rest.client.reviews.v1.ReviewsRestClient;
import maltsau.maksim.bff.sites.classic.aop.ExecutionTimeLoggable;
import maltsau.maksim.bff.sites.classic.dto.EquipmentRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/reviewaggregator/v1/equipmentreviews/",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewAggregatorResourceV1 {


    private ReviewsRestClient reviewsRestClient;

    private EquipmentRestClient equipmentRestClient;

    private ConversionService conversionService;

    @Autowired
    public ReviewAggregatorResourceV1(ReviewsRestClient reviewsRestClient,
                                      EquipmentRestClient equipmentRestClient,
                                      ConversionService conversionService) {
        this.reviewsRestClient = reviewsRestClient;
        this.equipmentRestClient = equipmentRestClient;
        this.conversionService = conversionService;
    }

    @GetMapping("/pages/{pageNum}/")
    @ExecutionTimeLoggable
    public List<EquipmentRatings> getPage(@PathVariable("pageNum") Integer pageNum) {
        Future<List<EquipmentReview>> equipmentReviewsFuture = reviewsRestClient.getEquipmentReviewsAsync();
        List<Equipment> equipments = equipmentRestClient.getEquipments();

        Map<Long, Double> equipmentRatingsMap = Futures.getUnchecked(equipmentReviewsFuture).stream()
                .collect(Collectors.groupingBy(EquipmentReview::getEquipmentId,
                        Collectors.averagingInt(EquipmentReview::getStarRating)));

        return equipments.stream()
                .parallel()
                .map(e -> conversionService.convert(e, EquipmentRatings.class))
                .filter(Objects::nonNull)
                .peek(e -> e.setAverageStartRating(equipmentRatingsMap.get(e.getId())))
                .collect(Collectors.toList());
    }


}
