import EquipmentReviewDto from "../dto/equipment-review-dto";
import CommonRestClient from "./common-rest-client";


export default class EquipmentReviewRestClient {
  private commonRestClient: CommonRestClient
  constructor() {
    this.commonRestClient = new CommonRestClient();
  }

  public getEquipmentReviews(): Promise<EquipmentReviewDto[]> {
    return this.commonRestClient.executeGet('/api/reviews/v1/');
  }
}