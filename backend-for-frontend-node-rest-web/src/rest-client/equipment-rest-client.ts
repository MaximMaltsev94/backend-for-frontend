import EquipmentDto from '../dto/equipment-dto';

export default interface EquipmentRestClient {
  getEquipment(): Promise<EquipmentDto[]>;
}
