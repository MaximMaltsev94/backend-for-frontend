import { Router } from "express";
import reviewAggregator from "./routes/review-aggregator";

export default () => {
  const app = Router();

  reviewAggregator(app);

  return app;
}