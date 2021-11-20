import EquipmentModel from '../models/equipment-model';
import { inject, injectable } from 'inversify';
import EquipmentService from './equipment-service';
import EquipmentRepository from '../repository/equipment-repository';
import { TYPES } from '../ioc-di/types';

@injectable()
export default class EquipmentServiceImpl implements EquipmentService {
  private equipmentRepository: EquipmentRepository;

  constructor(@inject(TYPES.EquipmentRepository) equipmentRepository: EquipmentRepository) {
    this.equipmentRepository = equipmentRepository;
  }

  getAllModels(): Promise<EquipmentModel[]> {
    return this.equipmentRepository.findAllModels();
  }
}
