package maltsau.maksim.bff.rest.client.equipment.v1;

import maltsau.maksim.bff.rest.client.equipment.dto.Equipment;

import java.util.List;

public interface EquipmentRestClient {
    List<Equipment> getEquipments();
}
