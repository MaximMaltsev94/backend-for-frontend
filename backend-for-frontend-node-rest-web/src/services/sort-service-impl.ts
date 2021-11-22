import { injectable } from 'inversify';
import SortService from './sort-service';

@injectable()
export default class SortServiceImpl implements SortService {
  public sortArray(arr: number[]): number[] {
    return this.insertionSort(arr);
  }

  private insertionSort(arr: number[]): number[] {
    for (let i = 0; i < arr.length; i++) {
      let minPos: number = i;
      for (let j: number = i + 1; j < arr.length; j++) {
        minPos = arr[j] < arr[minPos] ? j : minPos;
      }

      const tmp = arr[i];
      arr[i] = arr[minPos];
      arr[minPos] = tmp;
    }
    return arr;
  }
}
