export default {
  api: {
    prefix: '/api',
  },
  port: 8080,
  equipmentRestClient: {
    host: 'http://192.168.100.12:8081',
  },
  equipmentReviewsRestClient: {
    host: 'http://192.168.100.12:8081',
  },
  mongodbConnectionString: 'mongodb://192.168.100.12:27017/',
  mongodbDatabseName: 'equipment',
};
