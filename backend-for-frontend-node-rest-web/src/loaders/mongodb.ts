import config from '../config';
import { Collection, Db, MongoClient } from 'mongodb';
import { mongodbEquipmentCollections } from '../repository/mongodb';
import EquipmentModel from '../models/equipment-model';

export default async (): Promise<void> => {
  const client: MongoClient = new MongoClient(config.mongodbConnectionString);
  await client.connect();
  console.log('connected to mongo');
  const db: Db = client.db(config.mongodbDatabseName);
  const modelsCollection: Collection = db.collection(EquipmentModel.COLLECTION_NAME);
  mongodbEquipmentCollections.models = modelsCollection;
};
