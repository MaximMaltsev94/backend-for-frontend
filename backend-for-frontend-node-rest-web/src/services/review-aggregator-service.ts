import EquipmentRestClient from "../rest-client/equipment-rest-client";
import EquipmentAverageRatingsDto from "../dto/equipment-aggregate-rating";
import EquipmentReviewDto from "../dto/equipment-review-dto";
import EquipmentReviewRestClient from "../rest-client/equipment-review-rest-client";


export default class ReviewAggregatorService {
  private equipmentRestClient: EquipmentRestClient;
  private equipmentReviewRestClient: EquipmentReviewRestClient;

  constructor() {
    this.equipmentRestClient = new EquipmentRestClient();
    this.equipmentReviewRestClient = new EquipmentReviewRestClient();
  }

  public getEquipmentAverageRating(): Promise<EquipmentAverageRatingsDto[]> {
    const equipmentAverageRating = this.equipmentReviewRestClient.getEquipmentReviews()
      .then(this.mapEquipmentReviewsToStarsRating)
      .then(this.calculateAverageRating);

    const equipment = this.equipmentRestClient.getEquipment();

    return Promise.all([equipmentAverageRating, equipment]).then(([equipmentAverageRating, equipment]) => {
      return equipment.map(e => {
        const result: EquipmentAverageRatingsDto = e;
        result.averageStarRating = equipmentAverageRating[`${e.id}`]
        return result
      });
    })
  }

  private mapEquipmentReviewsToStarsRating(equipmentReviews: EquipmentReviewDto[]): { [key: string]: number[] } {
    return equipmentReviews.reduce((current, next) => {
      if (!current[`${next.equipmentId}`]) {
        current[`${next.equipmentId}`] = []
      }
      current[`${next.equipmentId}`].push(next.starRating)
      return current
    }, {})
  }

  private calculateAverageRating(equipmentRatingsMap: { [key: string]: number[] }): { [key: string]: number } {
    const averageRating = {}
    for (const [key, value] of Object.entries(equipmentRatingsMap)) {
      const sum = value.reduce((a, b) => a + b)
      averageRating[key] = sum / value.length
    }
    return averageRating;
  }
}