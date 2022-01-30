import config from '../config';
import fetch from 'node-fetch';
import CommonRestClient from './common-rest-client';
import { injectable } from 'inversify';

@injectable()
export default class CommonRestClientImpl implements CommonRestClient {
  private host: string;
  constructor() {
    this.host = config.equipmentRestClient.host;
  }

  public executeGet = async <T>(url: string): Promise<T> => {
    const res = await fetch(`${this.host}${url}`);
    if (res.status > 200) {
      Promise.reject(`non-200 : ${res.status}`);
    }
    return res.json();
  };
}
