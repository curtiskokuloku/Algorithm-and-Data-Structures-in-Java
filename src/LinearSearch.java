// Implementation of a Linear search on an array of integers
public class LinearSearch {
    public static int search(int[] arr, int n, int x) {
        // Search for value 'x' in the array 'arr' in a linear manner
        // Return the index of the element if found, -1 otherwise
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 2, 10, 15, 20};
        int n = arr.length;
        int x = 15;

        // Measure time for search() method
        long startTime = System.nanoTime();
        int result = search(arr, n, x);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        System.out.println(x + " found at index " + result);
        System.out.println("Time taken for LinearSearch: " + timeTaken / 1000000.0 + " milliseconds");
    }

}
