import { injectable } from 'inversify';
import EquipmentModel from '../models/equipment-model';
import EquipmentRepository from './equipment-repository';
import mongodb from 'mongodb';
import { mongodbEquipmentCollections } from './mongodb';

@injectable()
export default class EquipmentRepositoryImpl implements EquipmentRepository {
  findAllModels(): Promise<EquipmentModel[]> {
    return new Promise((resolve, reject) => {
      mongodbEquipmentCollections.models
        .find()
        .toArray()
        .then(documents => {
          return documents.map(this.mapToEquipmentModel);
        })
        .then(resolve)
        .catch(reject);
    });
  }

  private mapToEquipmentModel(document: mongodb.Document): EquipmentModel {
    return new EquipmentModel(document['_id'], document['title'], document['description'], document['properties']);
  }
}
