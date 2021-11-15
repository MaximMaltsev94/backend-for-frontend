package maltsau.maksim.bff.sites.classic.service;

import maltsau.maksim.bff.sites.classic.domain.EquipmentModel;
import maltsau.maksim.bff.sites.classic.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * EquipmentService.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/15/2021
 *
 * @author Maksim Maltsau
 */
@Service
public class EquipmentService {

    private EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<EquipmentModel> getAll() {
        return equipmentRepository.findAll();
    }
}
