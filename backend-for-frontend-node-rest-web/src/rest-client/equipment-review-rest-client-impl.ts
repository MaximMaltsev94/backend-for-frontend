import { TYPES } from '@/ioc-di/types';
import { inject, injectable } from 'inversify';
import EquipmentReviewDto from '../dto/equipment-review-dto';
import CommonRestClient from './common-rest-client';
import EquipmentReviewRestClient from './equipment-review-rest-client';

@injectable()
export default class EquipmentReviewRestClientImpl implements EquipmentReviewRestClient {
  private commonRestClient: CommonRestClient;

  constructor(@inject(TYPES.CommonRestClient) commonRestClient: CommonRestClient) {
    this.commonRestClient = commonRestClient;
  }

  public getEquipmentReviews(): Promise<EquipmentReviewDto[]> {
    return this.commonRestClient.executeGet('/api/reviews/v1/');
  }
}
