import { Router } from 'express';
import reviewAggregator from './routes/review-aggregator';

export default (): Router => {
  const app = Router();

  reviewAggregator(app);

  return app;
};
