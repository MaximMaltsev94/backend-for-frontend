package maltsau.maksim.bff.rest.client.equipment.v1;

import maltsau.maksim.bff.rest.client.equipment.dto.Equipment;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ReactiveEquipmentRestClient {
    Mono<List<Equipment>> getEquipments();
}
