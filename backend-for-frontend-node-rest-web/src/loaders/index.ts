import expressloader from './express';
import mongodbLoader from './mongodb';

export default async ({ expressApp }): Promise<void> => {
  await expressloader({ app: expressApp });
  await mongodbLoader();
  console.info('✌️ Express loaded');
};
