import { inversifyContainer } from '../../ioc-di/inversify.config';
import { TYPES } from '../../ioc-di/types';
import ReviewAggregatorService from '../../services/review-aggregator-service';
import { Request, Response, Router } from 'express';
const route = Router();

const reviewAggregatorService = inversifyContainer.get<ReviewAggregatorService>(TYPES.ReviewAggregatorService);

export default (app: Router): void => {
  app.use('/reviewaggregator/v1', route);

  route.get('/equipmentreviews/pages/:pagenum', async (req: Request, res: Response) => {
    reviewAggregatorService.getEquipmentAverageRating().then(equipmentAverageRatings => {
      res.json(equipmentAverageRatings).status(200);
    });
  });
};
