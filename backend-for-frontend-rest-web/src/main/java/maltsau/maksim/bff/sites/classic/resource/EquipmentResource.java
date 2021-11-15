package maltsau.maksim.bff.sites.classic.resource;

import maltsau.maksim.bff.sites.classic.domain.EquipmentModel;
import maltsau.maksim.bff.sites.classic.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Equipment resource.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/14/2021
 *
 * @author Maksim Maltsau
 */
@RestController
@RequestMapping(value = "/equipment/v1/",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class EquipmentResource {

    private EquipmentService equipmentService;

    @Autowired
    public EquipmentResource(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/models")
    public List<EquipmentModel> getAllModels() {
        return equipmentService.getAll();
    }
}
