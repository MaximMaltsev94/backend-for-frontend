import { inversifyContainer } from '../../ioc-di/inversify.config';
import { TYPES } from '../../ioc-di/types';
import { Request, Response, Router } from 'express';
import EquipmentService from '../../services/equipment-service';
import EquipmentModel from '../../models/equipment-model';
const route = Router();

const reviewAggregatorService = inversifyContainer.get<EquipmentService>(TYPES.EquipmentService);

export default (app: Router): void => {
  app.use('/equipment/v1', route);

  route.get('/models/', async (req: Request, res: Response) => {
    const allModels: EquipmentModel[] = await reviewAggregatorService.getAllModels();
    res.json(allModels).status(200).end();
  });
};
