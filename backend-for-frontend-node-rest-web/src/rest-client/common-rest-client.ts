export default interface CommonRestClient {
  executeGet<T>(url: string): Promise<T>;
}
