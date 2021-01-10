package maltsau.maksim.bff.sites.classic.dto;

import java.util.Map;

public class EquipmentRatings {
    private Long id;

    private String title;
    private String description;
    private Map<String, String> properties;

    private Double averageStartRating;

    public EquipmentRatings() {
        //default constructor
    }

    public EquipmentRatings(Long id, String title, String description, Map<String, String> properties, Double averageStartRating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.properties = properties;
        this.averageStartRating = averageStartRating;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public Double getAverageStartRating() {
        return averageStartRating;
    }

    public void setAverageStartRating(Double averageStartRating) {
        this.averageStartRating = averageStartRating;
    }
}
