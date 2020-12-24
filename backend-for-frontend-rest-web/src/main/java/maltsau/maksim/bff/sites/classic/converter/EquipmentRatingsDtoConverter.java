package maltsau.maksim.bff.sites.classic.converter;

import maltsau.maksim.bff.rest.client.equipment.dto.Equipment;
import maltsau.maksim.bff.sites.classic.dto.EquipmentRatings;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EquipmentRatingsDtoConverter implements Converter<Equipment, EquipmentRatings> {
    @Override
    public EquipmentRatings convert(Equipment equipment) {
        return new EquipmentRatings(
                equipment.getId(),
                equipment.getTitle(),
                equipment.getDescription(),
                equipment.getProperties(),
                null
        );
    }
}
