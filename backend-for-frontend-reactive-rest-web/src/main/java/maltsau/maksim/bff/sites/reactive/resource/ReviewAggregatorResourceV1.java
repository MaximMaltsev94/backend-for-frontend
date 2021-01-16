package maltsau.maksim.bff.sites.reactive.resource;

import maltsau.maksim.bff.rest.client.equipment.dto.Equipment;
import maltsau.maksim.bff.rest.client.equipment.v1.ReactiveEquipmentRestClient;
import maltsau.maksim.bff.rest.client.reviews.dto.EquipmentReview;
import maltsau.maksim.bff.rest.client.reviews.v1.ReactiveReviewRestClient;
import maltsau.maksim.bff.sites.reactive.dto.EquipmentRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/reviewaggregator/v1/equipmentreviews/",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewAggregatorResourceV1 {

    private ReactiveReviewRestClient reactiveReviewRestClient;

    private ReactiveEquipmentRestClient reactiveEquipmentRestClient;

    @Autowired
    public void setReactiveReviewRestClient(ReactiveReviewRestClient reactiveReviewRestClient) {
        this.reactiveReviewRestClient = reactiveReviewRestClient;
    }

    @Autowired
    public void setReactiveEquipmentRestClient(ReactiveEquipmentRestClient reactiveEquipmentRestClient) {
        this.reactiveEquipmentRestClient = reactiveEquipmentRestClient;
    }

    @GetMapping("/pages/{pageNum}/")
    public Mono<List<EquipmentRatings>> getPage(@PathVariable("pageNum") Integer pageNum) {
        Mono<List<EquipmentReview>> equipmentReviewsMono = reactiveReviewRestClient.getEquipmentReviews();
        Mono<List<Equipment>> equipmentsMono = reactiveEquipmentRestClient.getEquipments();

        return Mono.zip(equipmentReviewsMono, equipmentsMono, (equipmentReviews, equipments) -> {
            Map<Long, Double> equipmentRatingsMap = equipmentReviews.stream()
                    .collect(Collectors.groupingBy(EquipmentReview::getEquipmentId,
                            Collectors.averagingInt(EquipmentReview::getStarRating)));

            return equipments.stream()
                    .parallel()
                    .map(e -> new EquipmentRatings(
                            e.getId(),
                            e.getTitle(),
                            e.getDescription(),
                            e.getProperties(),
                            null))
                    .peek(e -> e.setAverageStartRating(equipmentRatingsMap.get(e.getId())))
                    .collect(Collectors.toList());
        });
    }
}
