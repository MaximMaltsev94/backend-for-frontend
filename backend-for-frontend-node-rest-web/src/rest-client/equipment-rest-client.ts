import EquipmentDto from "../dto/equipment-dto";
import CommonRestClient from "./common-rest-client";


export default class EquipmentRestClient {
  private commonRestClient: CommonRestClient
  constructor() {
    this.commonRestClient = new CommonRestClient();
  }

  public getEquipment(): Promise<EquipmentDto[]> {
    return this.commonRestClient.executeGet('/api/equipment/v1/');
  }
}