import config from '../config';
import fetch from 'node-fetch';

export default class CommonRestClient {
  private host: string;
  constructor() {
    this.host = config.equipmentRestClient.host;
  }

  public executeGet = <T>(url: string): Promise<T> => {
    return new Promise((resolve, reject) => {
      fetch(`${this.host}${url}`)
        .then(res => {
          if (res.status > 200) {
            throw `non-200 : ${res.status}`;
          }
          resolve(res.json());
        })
        .catch(reject);
    });
  };
}
