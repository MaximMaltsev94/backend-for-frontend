import EquipmentDto from "@/dto/equipmentDto";
import fetch from "node-fetch"
import config from "../config"

const getEquipmentReviews = (): Promise<EquipmentReviewDto[]> => {
  return executeGet('/api/reviews/v1/');
}

const getEquipment = (): Promise<EquipmentDto[]> => {
  return executeGet('/api/equipment/v1/');
}

const executeGet = <T>(url): Promise<T> => {
  const host = config.equipmentRestClient.host;

  return new Promise((resolve, reject) => {
    fetch(`${host}${url}`)
      .then(res => {
        if (res.status > 200) {
          throw `non-200 : ${res.status}`
        }
        resolve(res.json())
      })
      .catch(reject)
  })
}

const mapEquipmentReviewsToStarsRating = (equipmentReviews: EquipmentReviewDto[]): { [key: string]: number[] } => equipmentReviews.reduce((current, next) => {
  if (!current[`${next.equipmentId}`]) {
    current[`${next.equipmentId}`] = []
  }
  current[`${next.equipmentId}`].push(next.starRating)
  return current
}, {})

const calculateAverageRating = (equipmentRatingsMap: { [key: string]: number[] }): { [key: string]: number } => {
  const averageRating = {}
  for (const [key, value] of Object.entries(equipmentRatingsMap)) {
    const sum = value.reduce((a, b) => a + b)
    averageRating[key] = sum / value.length
  }
  return averageRating;
}

interface EquipmentReviewDto {
  id: number,
  equipmentId: number,
  authorName: string,
  starRating: number
}

interface EquipmentAverageRatingsDto extends EquipmentDto {
  averageStarRating?: number
}

export default class ReviewAggregatorService {

  public getEquipmentAverageRating(): Promise<EquipmentAverageRatingsDto[]> {
    const equipmentAverageRating = getEquipmentReviews()
      .then(mapEquipmentReviewsToStarsRating)
      .then(calculateAverageRating);

    const equipment = getEquipment();
    
    return Promise.all([equipmentAverageRating, equipment]).then(([equipmentAverageRating, equipment]) => {
      return equipment.map(e => {
        const result: EquipmentAverageRatingsDto = e;
        result.averageStarRating = equipmentAverageRating[`${e.id}`]
        return result
      });
    })
  }
}