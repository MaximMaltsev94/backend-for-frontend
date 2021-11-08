import { Request, Response, Router } from "express";
import ReviewAggregatorService from "../../services/reviewAggregatorService";
const route = Router();

export default (app: Router) => {
  app.use('/reviewaggregator/v1', route);

  route.get("/equipmentreviews/pages/:pagenum", async (req: Request, res: Response) => {

    new ReviewAggregatorService().getEquipmentAverageRating().then(equipmentAverageRatings => {
      res.json(equipmentAverageRatings).status(200);
    });

  })
}