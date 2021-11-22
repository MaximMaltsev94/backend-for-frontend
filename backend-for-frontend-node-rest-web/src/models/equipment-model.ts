export default class EquipmentModel {
  public static readonly COLLECTION_NAME: string = 'models';

  constructor(
    public id: string,
    public title: string,
    public description: string,
    public properties: { TPD: string },
  ) {}
}
