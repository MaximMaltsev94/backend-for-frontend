import EquipmentModel from '../models/equipment-model';

export default interface EquipmentService {
  getAllModels(): Promise<EquipmentModel[]>;
}
