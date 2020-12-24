package maltsau.maksim.bff.rest.client.equipment.v1;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import maltsau.maksim.bff.rest.client.equipment.dto.Equipment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EquipmentRestClientImpl implements EquipmentRestClient {
    @Override
    public List<Equipment> getEquipments() {
        return Lists.newArrayList(
                new Equipment(1L, "ryzen 5600x", "ZEN 3 processor", ImmutableMap.of("TDP", "65W")),
                new Equipment(2L, "ryzen 3600x", "ZEN 3 processor", ImmutableMap.of("TDP", "95W")),
                new Equipment(3L, "ryzen 2600", "ZEN 2 processor", ImmutableMap.of("TDP", "65W")),
                new Equipment(4L, "ryzen 5800x", "ZEN 3 processor", ImmutableMap.of("TDP", "105W")),
                new Equipment(5L, "ryzen 3700x", "ZEN 3 processor", ImmutableMap.of("TDP", "65W")),
                new Equipment(6L, "ryzen 5950X", "ZEN 3 processor", ImmutableMap.of("TDP", "105W"))
        );
    }
}
