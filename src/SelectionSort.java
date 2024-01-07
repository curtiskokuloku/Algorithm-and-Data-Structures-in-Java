// Implementation of Selection Sort algorithm
public class SelectionSort {
    public static void display(int[] arr) {
        // Print the elements in the array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n-1) System.out.print(", ");
        }
        System.out.println();
    }

    private static void selectionSort(int[] arr) {
        // Uses the selection sort algorithm to sort an unsorted array of integers
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 2, 10};
        System.out.print("Before: ");
        display(arr);

        long startTime = System.nanoTime();
        selectionSort(arr);
        long endTime = System.nanoTime();

        System.out.print("After: ");
        display(arr);

        long timeTaken = endTime - startTime;
        double timeTakenInMillis = (double) timeTaken / 1_000_000;
        System.out.println("Time taken for selectionSort: " + timeTakenInMillis + " milliseconds");
    }
}
