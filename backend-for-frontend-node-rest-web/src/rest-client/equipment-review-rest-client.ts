import EquipmentReviewDto from '../dto/equipment-review-dto';

export default interface EquipmentReviewRestClient {
  getEquipmentReviews(): Promise<EquipmentReviewDto[]>;
}
