import { Router } from "express";
import reviewAggregator from "./routes/reviewAggregator";

export default () => {
  const app = Router();

  reviewAggregator(app);

  return app;
}