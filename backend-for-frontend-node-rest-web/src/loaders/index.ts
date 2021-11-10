import expressloader from './express';

export default async ({ expressApp }) => {
  await expressloader({ app: expressApp });
  console.info('✌️ Express loaded');
};
