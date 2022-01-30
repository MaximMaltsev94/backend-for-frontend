import { injectable } from 'inversify';
import EquipmentModel from '../models/equipment-model';
import EquipmentRepository from './equipment-repository';
import mongodb from 'mongodb';
import { mongodbEquipmentCollections } from './mongodb';

@injectable()
export default class EquipmentRepositoryImpl implements EquipmentRepository {
  async findAllModels(): Promise<EquipmentModel[]> {
    const documents: mongodb.Document[] = await mongodbEquipmentCollections.models.find().toArray();
    return documents.map(this.mapToEquipmentModel);
  }

  private mapToEquipmentModel(document: mongodb.Document): EquipmentModel {
    return new EquipmentModel(document['_id'], document['title'], document['description'], document['properties']);
  }
}
