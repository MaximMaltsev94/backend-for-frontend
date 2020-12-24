package maltsau.maksim.bff.rest.client.reviews.dto;

public class EquipmentReview {
    private Long id;
    private Long equipmentId;
    private String authorName;
    private Integer startRating;

    public EquipmentReview(Long id, Long equipmentId, String authorName, Integer startRating) {
        this.id = id;
        this.equipmentId = equipmentId;
        this.authorName = authorName;
        this.startRating = startRating;
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

    public Integer getStartRating() {
        return startRating;
    }
}
