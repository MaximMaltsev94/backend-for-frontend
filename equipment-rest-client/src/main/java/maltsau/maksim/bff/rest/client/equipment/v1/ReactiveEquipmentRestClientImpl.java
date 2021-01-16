package maltsau.maksim.bff.rest.client.equipment.v1;

import maltsau.maksim.bff.rest.client.core.reactive.ReactiveRestClientTemplate;
import maltsau.maksim.bff.rest.client.equipment.dto.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Component
public class ReactiveEquipmentRestClientImpl implements ReactiveEquipmentRestClient {

    private ReactiveRestClientTemplate reactiveEquipmentRestClientTemplate;

    @Autowired
    @Qualifier("reactiveEquipmentRestClientTemplate")
    public void setReactiveEquipmentRestClientTemplate(ReactiveRestClientTemplate reactiveEquipmentRestClientTemplate) {
        this.reactiveEquipmentRestClientTemplate = reactiveEquipmentRestClientTemplate;
    }

    @Override
    public Mono<List<Equipment>> getEquipments() {
        return reactiveEquipmentRestClientTemplate.getList("/api/equipment/v1/", Collections.emptyMap(), Equipment.class);
    }
}
