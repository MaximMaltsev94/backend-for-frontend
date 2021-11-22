import { TYPES } from '../ioc-di/types';
import { inject, injectable } from 'inversify';
import EquipmentDto from '../dto/equipment-dto';
import CommonRestClient from './common-rest-client';
import EquipmentRestClient from './equipment-rest-client';

@injectable()
export default class EquipmentRestClientImpl implements EquipmentRestClient {
  private commonRestClient: CommonRestClient;
  constructor(@inject(TYPES.CommonRestClient) commonRestClient: CommonRestClient) {
    this.commonRestClient = commonRestClient;
  }

  public getEquipment(): Promise<EquipmentDto[]> {
    return this.commonRestClient.executeGet('/api/equipment/v1/');
  }
}
