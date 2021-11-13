import EquipmentAverageRatingsDto from '../dto/equipment-aggregate-rating';

export default interface ReviewAggregatorService {
  getEquipmentAverageRating(): Promise<EquipmentAverageRatingsDto[]>;
}
