import express from 'express';
import config from './config';

const startServer = async () => {
  const app = express();

  await require('./loaders').default({ expressApp: app });
  app
    .listen(config.port, () => {
      console.log(`listening on port ${config.port}`);
    })
    .on('error', err => {
      console.error(err);
      process.exit(1);
    });
};

startServer();
