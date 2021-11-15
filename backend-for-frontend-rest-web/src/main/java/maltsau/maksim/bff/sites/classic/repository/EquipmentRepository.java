package maltsau.maksim.bff.sites.classic.repository;

import maltsau.maksim.bff.sites.classic.domain.EquipmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * MongoDB repository for access to `model` collection.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/14/2021
 *
 * @author Maksim Maltsau
 */
@Repository
public class EquipmentRepository {

    private MongoOperations mongoOperations;

    @Autowired
    public EquipmentRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public List<EquipmentModel> findAll() {
        return mongoOperations.findAll(EquipmentModel.class, EquipmentModel.COLLECTION_NAME);
    }
}
