import SortService from '../../services/sort-service';
import { Request, Response, Router } from 'express';
import { inversifyContainer } from '../../ioc-di/inversify.config';
import { TYPES } from '../../ioc-di/types';
const route = Router();

const sortService = inversifyContainer.get<SortService>(TYPES.SortService);

export default (app: Router): void => {
  app.use('/sorted-random-string/v1', route);

  route.get('/:length', async (req: Request, res: Response) => {
    const length: number = +req.params.length;
    const arr: number[] = Array.from({ length: length }, () => Math.floor(Math.random() * 1000));
    const sortedArray = sortService.sortArray(arr);

    res.json({ sortedArray: sortedArray }).status(200).end();
  });
};
