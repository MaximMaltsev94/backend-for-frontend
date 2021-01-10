package maltsau.maksim.bff.rest.client.reviews.dto;

public class EquipmentReview {
    private Long id;
    private Long equipmentId;
    private String authorName;
    private Integer starRating;

    public EquipmentReview() {
        //default constructor
    }

    public EquipmentReview(Long id, Long equipmentId, String authorName, Integer starRating) {
        this.id = id;
        this.equipmentId = equipmentId;
        this.authorName = authorName;
        this.starRating = starRating;
    }

    public Long getId() {
        return id;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Integer getStarRating() {
        return starRating;
    }
}
