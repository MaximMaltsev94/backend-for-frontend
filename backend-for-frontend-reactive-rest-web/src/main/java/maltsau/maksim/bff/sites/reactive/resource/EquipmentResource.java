package maltsau.maksim.bff.sites.reactive.resource;

import maltsau.maksim.bff.sites.reactive.domain.EquipmentModel;
import maltsau.maksim.bff.sites.reactive.service.EquipmentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Equipment resource.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/15/2021
 *
 * @author Maksim Maltsau
 */
@RestController
@RequestMapping(value = "/equipment/v1/",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class EquipmentResource {

    private EquipmentService equipmentService;

    public EquipmentResource(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public Flux<EquipmentModel> get() {
        return equipmentService.getAll();
    }
}
