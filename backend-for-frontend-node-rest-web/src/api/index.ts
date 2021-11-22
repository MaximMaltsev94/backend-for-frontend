import { Router } from 'express';
import equipment from './routes/equipment';
import reviewAggregator from './routes/review-aggregator';
import sortedString from './routes/sorted-string';

export default (): Router => {
  const app = Router();

  reviewAggregator(app);
  equipment(app);
  sortedString(app);

  return app;
};
