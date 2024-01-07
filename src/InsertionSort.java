// Implementation of Insertion Sort algorithm
public class InsertionSort {
    public static void display(int[] arr) {
        // Print the elements in the array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n-1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void insertionSort(int[] arr) {
        // Uses the insertion sort algorithm to sort an unsorted array of integers
        int n = arr.length;
        for (int i = 1; i < n; i++) {   // unsorted part
            int temp = arr[i];
            int j = i - 1;              // sorted part
            while (j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];      // shift larger elements to temp by 1
                j = j - 1;
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 2, 10};
        System.out.print("Before: ");
        display(arr);

        // Measure time for insertionSort() method
        long startTime = System.nanoTime();
        insertionSort(arr);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        System.out.print("After: ");
        display(arr);

        System.out.println("Time taken for InsertionSort: " + timeTaken / 1000000.0 + " milliseconds");
    }

}
