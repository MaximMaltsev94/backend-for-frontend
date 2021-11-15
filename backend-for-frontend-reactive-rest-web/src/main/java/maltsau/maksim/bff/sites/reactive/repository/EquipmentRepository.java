package maltsau.maksim.bff.sites.reactive.repository;

import maltsau.maksim.bff.sites.reactive.domain.EquipmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * MongoDB repository for access to `model` collection.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/14/2021
 *
 * @author Maksim Maltsau
 */
@Repository
public class EquipmentRepository {

    private ReactiveMongoOperations mongoOperations;

    @Autowired
    public EquipmentRepository(ReactiveMongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Flux<EquipmentModel> findAll() {
        return mongoOperations.findAll(EquipmentModel.class, EquipmentModel.COLLECTION_NAME);
    }
}
