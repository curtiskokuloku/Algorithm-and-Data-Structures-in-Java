// Implementation of Bubble Sort algorithm
public class BubbleSort {
    public static void display(int[] arr) {
        // Print the elements in the array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n-1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        // Uses the bubble sort algorithm to sort an unsorted array of integers
        int n = arr.length;
        boolean isSwapped;  // Determine if two elements have been swapped
        for (int i = 0; i < n-1; i++) {
            isSwapped = false;
            for (int j = 0; j < n-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 2, 10};
        System.out.print("Before: ");
        display(arr);

        // Measure time for bubbleSort() method
        long startTime = System.nanoTime();
        bubbleSort(arr);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        System.out.print("After: ");
        display(arr);

        System.out.println("Time taken for BubbleSort: " + timeTaken / 1000000.0 + " milliseconds");
    }

}