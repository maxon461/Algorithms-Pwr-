import java.util.Random;

public class App {
    static int checks = 0, swaps = 0;

    Random rand = new Random();

    // Random generator of int's
    public static void rand_generator(int[] arr, int n) {
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(0, n * n);
            System.out.println(arr[i]);
        }
    }

    public static void P_rand_generator(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            arr[i] = i;
    }

    // Bad generator
    public static void B_rand_generator(int[] arr, int n) {

    }

    // Sort methods
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int checks = 0, swaps = 0;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                checks++;
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first
            // element
            if (min_idx != i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
                swaps++;
            }
        }
        System.out.println("checks in selection: " + checks + " swaps in selection: " + swaps);
    }

    public static void insertionSort(int arr[]) {
        int n = arr.length;
        int checks = 0, swaps = 0;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            checks++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                swaps++;
                checks++;
                j = j - 1;
            }
            arr[j + 1] = key;
            swaps++;
        }
        System.out.println("checks in insertion: " + checks + " swaps in insertion: " + swaps / 3);
    }
    // Merge sort

    public static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i) {
            swaps++;
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            swaps++;
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            checks++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                swaps++;
                i++;
            } else {
                arr[k] = R[j];
                swaps++;
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            swaps++;
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            swaps++;
            j++;
            k++;
        }
        System.out.println("Checks : " + checks + " Swaps: " + swaps);
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    // End of merge sort

    // Quick sort
    // swap method
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];
        

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            checks++;
            if (arr[j] < pivot) {

                i++;
                swap(arr, i, j);
                swaps+=3;
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // main method
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            checks++;
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // End of quick sort
    public static void main(String[] args) throws Exception {

        int[] arr = new int[16];
        rand_generator(arr, arr.length);
        int n = arr.length - 1;

        // selectionSort(arr);

        // insertionSort(arr);

        // Merge sort
        // sort(arr, 0, n );

        // Quick sort
        quickSort(arr, 0, n);

        System.out.println("checks in merge: " + checks + " swaps in merge: " + swaps / 3);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

    }
}
// [1,0,2,3,45,6]
// [0,1,2,3,45,6] -- swap
// [0,0,2,3,45,6] -- 1/3 swap