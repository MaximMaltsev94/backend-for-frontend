package maltsau.maksim.bff.rest.client.equipment.v1;

import maltsau.maksim.bff.rest.client.core.RestClientTemplate;
import maltsau.maksim.bff.rest.client.equipment.dto.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class EquipmentRestClientImpl implements EquipmentRestClient {

    private RestClientTemplate equipmentRestClientTemplate;

    @Autowired
    @Qualifier("equipmentRestClientTemplate")
    public void setEquipmentRestClientTemplate(RestClientTemplate equipmentRestClientTemplate) {
        this.equipmentRestClientTemplate = equipmentRestClientTemplate;
    }

    @Override
    public List<Equipment> getEquipments() {
        return equipmentRestClientTemplate.getList("/api/equipment/v1/", Collections.emptyMap(), Equipment.class);
    }
}
