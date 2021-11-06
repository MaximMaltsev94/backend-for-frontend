import express from "express";
import fetch from "node-fetch"

import config from "./config"

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

const mapEquipmentReviewsToStarsRating = (equipmentReviews: EquipmentReviewDto[]) : {[key: string]: number[]} => equipmentReviews.reduce((current, next) => {
  if (!current[`${next.equipmentId}`]) {
    current[`${next.equipmentId}`] = []
  }
  current[`${next.equipmentId}`].push(next.starRating)
  return current
}, {})

const calculateAverageRating = (equipmentRatingsMap: { [key: string]: number[] }) : {[key: string]: number} => {
  const averageRating = {}
  for (const [key, value] of Object.entries(equipmentRatingsMap)) {
    const sum = value.reduce((a, b) => a + b)
    averageRating[key] = sum / value.length
  }
  return averageRating;
}

interface EquipmentDto {
  id: string
  title: string
  description: string
  properties: {
    TPD: string
  }
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

const startServer = async () => {
  const app = express();

  app.get("/api/reviewaggregator/v1/equipmentreviews/pages/:pagenum", (request, response) => {
    const equipmentAverageRating = getEquipmentReviews()
      .then(mapEquipmentReviewsToStarsRating)
      .then(calculateAverageRating);

    const equipment = getEquipment();

    Promise.all([equipmentAverageRating, equipment]).then(([equipmentAverageRating, equipment]) => {

      response.send(equipment.map(e => {
        const result : EquipmentAverageRatingsDto = e;
        result.averageStarRating = equipmentAverageRating[`${e.id}`]
        return result
      }))
    })

  })

  app.listen(8080, () => {
    console.log('listening on port 8080')
  });
}

startServer();