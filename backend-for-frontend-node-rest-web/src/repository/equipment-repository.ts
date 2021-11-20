import EquipmentModel from '../models/equipment-model';

export default interface EquipmentRepository {
  findAllModels(): Promise<EquipmentModel[]>;
}
