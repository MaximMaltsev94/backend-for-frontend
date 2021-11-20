import { Router } from 'express';
import equipment from './routes/equipment';
import reviewAggregator from './routes/review-aggregator';

export default (): Router => {
  const app = Router();

  reviewAggregator(app);
  equipment(app);

  return app;
};
