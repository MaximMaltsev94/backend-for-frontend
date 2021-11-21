package maltsau.maksim.bff.sites.classic.service;

import org.springframework.stereotype.Service;

/**
 * Sort service.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/21/2021
 *
 * @author Maksim Maltsau
 */
@Service
public class SortService {

    public String sortString(String stringToSort) {
        return new String(insertionSort(stringToSort.toCharArray()));
    }

    private char[] insertionSort(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            char tmp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = tmp;
        }
        return arr;
    }


}
