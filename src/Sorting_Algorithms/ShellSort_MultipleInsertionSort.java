package Sorting_Algorithms;

class ShellSort_MultipleInsertionSort {
    void shellSort(int values[], int n) {
        int i = 0;
        int delta = n;
        do {
            delta = 1 + delta / 3;
            for (i = 0; i < delta; i++) {
                deltaInsertionSort(values, n, i, delta);
            }
        } while (delta > 1);
    } /* end ShellSort */

    void deltaInsertionSort(int values[], int n, int i, int delta) {
        int j = 0;
        int k = 0;
        int x = 0;

        j = i + delta;
        while (j < n) {
            x = values[j];
            k = j;
            while (k > 0 && values[k - delta] > x) {
                values[k] = values[k - delta];
                k = k - delta;
            }
            ;
            values[k] = x;

            j = j + delta;
        } /* end while */
    } /* end DeltaInsertionSort */
}
