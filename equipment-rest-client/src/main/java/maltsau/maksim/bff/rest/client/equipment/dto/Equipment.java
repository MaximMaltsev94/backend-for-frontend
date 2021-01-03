package maltsau.maksim.bff.rest.client.equipment.dto;

import java.util.Map;

public class Equipment {
    private Long id;
    private String title;
    private String description;
    private Map<String, String> properties;

    public Equipment() {
        //default constructor
    }

    public Equipment(Long id, String title, String description, Map<String, String> properties) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.properties = properties;
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
}
