// Given a sorted array of integers, rearrange the array in such a way that the first position
// will have the largest number, the second will have the smallest, the third will have the
// second-largest, and so on. Using O(1) extra space.
// i.e., Input: arr = {1, 2, 3, 4, 5, 6, 7}
//       Output: arr = {7, 1, 6, 2, 5, 3, 4}
public class RearrangeSortedArray {
    public static void display(int[] arr) {
        // Print the elements in the array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n-1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void rearrangeArray(int[] arr, int n) {   // O(n) runtime
        int i = 0;                // Pointer to the left of the array
        int j = arr.length-1;    // Pointer to the right of the array
        int max = arr[j] + 1;    // Maximum element in the array + 1

        for (int k = 0; k < n; k++) {
            // At even indices, store the maximum elements
            if (k % 2 == 0) {
                arr[k] += (arr[j] % max) * max;
                j--;
            } else {
                arr[k] += (arr[i] % max) * max;
                i++;
            }
        }

        // Divide all elements by 'max' to get the rearranged array
        for (i = 0; i < n; i++) {
            arr[i] = arr[i] / max;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("Input: ");
        display(arr);

        long startTime = System.nanoTime();
        rearrangeArray(arr, arr.length);
        long endTime = System.nanoTime();
        long timeTaken = (endTime - startTime);

        System.out.print("Output: ");   // 7, 1, 6, 2, 5, 3, 4
        display(arr);
        System.out.println("Time taken for rearrangeArray: " + timeTaken + " nanoseconds");

        arr = new int[]{2, 3, 5, 6, 8, 9};
        System.out.print("Input: ");
        display(arr);

        startTime = System.nanoTime();
        rearrangeArray(arr, arr.length);
        endTime = System.nanoTime();
        timeTaken = (endTime - startTime);

        System.out.print("Output: ");   // 9, 2, 8, 3, 6, 5
        display(arr);
        System.out.println("Time taken for rearrangeArray: " + timeTaken + " nanoseconds");
    }

}
