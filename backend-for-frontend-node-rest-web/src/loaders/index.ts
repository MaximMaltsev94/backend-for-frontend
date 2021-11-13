import expressloader from './express';

export default async ({ expressApp }): Promise<void> => {
  await expressloader({ app: expressApp });
  console.info('✌️ Express loaded');
};
