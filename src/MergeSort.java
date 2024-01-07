// Implementation of the Merge Sort algorithm
public class MergeSort {
    public static void display(int[] arr) {
        // Print the elements in the array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n-1) System.out.print(", ");
        }
        System.out.println();
    }


    public static void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);     // divide left part
            mergeSort(arr, temp, mid+1, high);  // divide right part
            merge(arr, temp, low, mid, high);        // sort left and right
        }
    }

    private static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        // Merge two arrays in sorted order
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int i = low, j = mid+1, k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 4, 3};
        int n = arr.length;
        int low = 0;
        int high = arr.length - 1;
        int[] temp = new int[n];
        System.out.print("Before: ");
        display(arr);

        long startTime = System.nanoTime();
        mergeSort(arr, temp, low, high);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        double timeTakenMilliseconds = timeTaken / 1e6; // Convert nanoseconds to milliseconds

        System.out.print("After: ");
        display(arr);
        System.out.println("Time taken for Merge Sort: " + timeTakenMilliseconds + " milliseconds");
    }

}
