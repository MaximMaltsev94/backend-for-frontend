import { inversifyContainer } from '../../ioc-di/inversify.config';
import { TYPES } from '../../ioc-di/types';
import { Request, Response, Router } from 'express';
import EquipmentService from '../../services/equipment-service';
const route = Router();

const reviewAggregatorService = inversifyContainer.get<EquipmentService>(TYPES.EquipmentService);

export default (app: Router): void => {
  app.use('/equipment/v1', route);

  route.get('/models/', async (req: Request, res: Response) => {
    reviewAggregatorService.getAllModels().then(equipmentModelDtos => {
      res.json(equipmentModelDtos).status(200);
    });
  });
};
