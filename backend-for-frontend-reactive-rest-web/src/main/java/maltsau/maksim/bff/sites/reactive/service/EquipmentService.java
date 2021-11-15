package maltsau.maksim.bff.sites.reactive.service;

import maltsau.maksim.bff.sites.reactive.domain.EquipmentModel;
import maltsau.maksim.bff.sites.reactive.repository.EquipmentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Equipment service.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/15/2021
 *
 * @author Maksim Maltsau
 */
@Service
public class EquipmentService {

    private EquipmentRepository equipmentRepository;

    public Flux<EquipmentModel> getAll() {
        return equipmentRepository.findAll();
    }
}
