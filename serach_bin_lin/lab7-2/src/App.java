import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class App {
    public static int checks = 0;

    public static void generateRandomArr(int[] arr , int n){
        Random rand = new Random();
        
        for(int i = 0; i <= n-1; i++){
            
            arr[i] = rand.nextInt(0,n*3);
        }
    }

    public static int linearSearch(int[] arr  , int what){
        int pos = 0 ;
        checks = 0;
        for(int i : arr){
            checks++;
            if(i==what){
                return pos;
            }
            else pos++;
        }
        // System.out.println("Checks in linear seearch: " + checks);

        return -1;
        
    }

//HeapSort
    public static void heapSort(int arr[])
    {
        int N = arr.length;
 
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }
//End of HeapSort

    public static void printArray(int arr[])
    {
        int N = arr.length;
 
        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static int BinarySearch(int [] arr ,  int what){
        
        checks = 0; 
        int left = 0 ;
        int right = arr.length-1;
        int middle;
        
        while(left<=right){
            middle  = (right+left)/2;
            
            
            if(arr[middle]==what) return middle;
            checks++;
            if(arr[middle]>what) {right=middle-1;checks++;}
            else  left = middle+1;
            
        }
        // System.out.println("Checks in Binary search: " + checks);
        return -1;
    }


    public static void main(String[] args) throws Exception {
        int [] arr = new int[128];
        generateRandomArr(arr, 128);
        printArray(arr);
        System.out.println(linearSearch(arr, 13));
        System.out.println("Checks in linear seearch: " + checks);
        // Function call
        heapSort(arr);
        printArray(arr);

       
        System.out.println(BinarySearch(arr , 13));
        System.out.println("Checks in Binary search: " + checks);

        // System.out.println("Sorted array is");
        // printArray(arr);

        
    }
}
