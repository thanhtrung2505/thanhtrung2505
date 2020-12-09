import java.io.IOException;
import java.util.Random;

public class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..higherIndex]
    //ham merge dc su dung de hop nhat 2 nua
    void merge(int arr[], int lowerIndex, int middle, int higherIndex) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - lowerIndex + 1;
        int n2 = higherIndex - middle;

        /* Create temp arrays */
        int Left[] = new int[n1];
        int Right[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            Left[i] = arr[lowerIndex + i];
        }
        for (int j = 0; j < n2; ++j) {
            Right[j] = arr[middle + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = lowerIndex;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            } else {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = Left[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[lowerIndex..higherIndex] using
    // merge()
    //ham sort tu goi de quy den trinh no khi 2 mang co size bang 1
    void sort(int arr[], int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            // Find the middle point
            int m = (lowerIndex + higherIndex) / 2;

            // Sort first and second halves
            sort(arr, lowerIndex, m);
            sort(arr, m + 1, higherIndex);

            // Merge the sorted halves
            merge(arr, lowerIndex, m, higherIndex);
        }
    }

    // Driver code
    public static void main(String args[]) throws IOException {

        DataView dv = new DataView();
        DataInput di = new DataInput();

        System.out.println("Enter number of array:");
        int length = 0;
        length = di.getInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(length);
        }

        dv.printArray(arr, dv.message[0]);
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
        dv.printArray(arr, dv.message[1]);
    }
}

