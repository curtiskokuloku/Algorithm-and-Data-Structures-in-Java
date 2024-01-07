// Implementation of Quick Sort algorithm
public class QuickSort {
    public static void display(int[] arr) {
        // Print the elements in the array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n-1) System.out.print(", ");
        }
        System.out.println();
    }

    public static int pivot(int[] arr, int low, int high) {
        // Pivot Selection Method which selects an element in the array as pivot
        return arr[high];   // last element
    }

    public static int partition(int[] arr, int low, int high) {
        // Partition Method used by Quick Sort algorithm to reorder the array according to the pivot
        int pivot = pivot(arr, low, high);
        int i = low, j = low;
        // low to j-1: smaller or equal to pivot
        // j to i-1: greater than pivot
        // i to high: yet to be traversed
        while (i <= high) {
            if (arr[i] <= pivot) {  // sort the elements left of pivot
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j-1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        // Recursive Method which repeatedly sorts the array but recursively sorting subarrays formed
        // to the left and right of pivot
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);   // left
            quickSort(arr, p+1, high);  // right
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, -3, 5, 2, 6, 9, -6, 1, 3};

        System.out.print("Before: ");
        display(arr);

        long startTime = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        long timeTaken = (endTime - startTime) / 1_000_000;

        System.out.print("After: ");
        display(arr);

        System.out.println("Time taken for quickSort: " + timeTaken + " milliseconds");
    }
}
