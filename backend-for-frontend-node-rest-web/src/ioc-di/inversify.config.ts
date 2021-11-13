import CommonRestClient from '../rest-client/common-rest-client';
import { Container } from 'inversify';
import { TYPES } from './types';
import CommonRestClientImpl from '../rest-client/common-rest-client-impl';
import EquipmentRestClient from '../rest-client/equipment-rest-client';
import EquipmentRestClientImpl from '../rest-client/equipment-rest-client-impl';
import EquipmentReviewRestClient from '../rest-client/equipment-review-rest-client';
import EquipmentReviewRestClientImpl from '../rest-client/equipment-review-rest-client-impl';
import ReviewAggregatorService from '../services/review-aggregator-service';
import ReviewAggregatorServiceImpl from '../services/review-aggregator-service-impl';

const inversifyContainer = new Container();
inversifyContainer.bind<CommonRestClient>(TYPES.CommonRestClient).to(CommonRestClientImpl);
inversifyContainer.bind<EquipmentRestClient>(TYPES.EquipmentRestClient).to(EquipmentRestClientImpl);
inversifyContainer.bind<EquipmentReviewRestClient>(TYPES.EquipmentReviewRestClient).to(EquipmentReviewRestClientImpl);
inversifyContainer.bind<ReviewAggregatorService>(TYPES.ReviewAggregatorService).to(ReviewAggregatorServiceImpl);

export { inversifyContainer };
