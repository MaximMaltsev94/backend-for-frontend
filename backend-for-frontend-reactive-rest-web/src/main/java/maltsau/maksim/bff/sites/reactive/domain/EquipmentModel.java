package maltsau.maksim.bff.sites.reactive.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * Domain object which represents `models` collection document.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/14/2021
 *
 * @author Maksim Maltsau
 */
@Document(collection = EquipmentModel.COLLECTION_NAME)
public class EquipmentModel {

    public static final String COLLECTION_NAME = "models";

    private Long id;
    private String title;
    private String description;
    private Map<String, String> properties;

    public EquipmentModel() {
        //default constructor
    }

    public EquipmentModel(Long id, String title, String description, Map<String, String> properties) {
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
