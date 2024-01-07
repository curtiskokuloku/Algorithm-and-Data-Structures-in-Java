// Implementation of a Binary search on a sorted array of integers
public class BinarySearch {
    public static int binarySearch(int[] arr, int low, int high, int key) {
        // Search for a 'key' in the array 'arr' starting at index 'low' and ending at index 'high'
        // If found, return the index of the key, -1 otherwise
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == key) return mid;
            if (key < arr[mid]) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 20, 47, 59, 65, 75, 88, 99};
        int low = 0;
        int high = arr.length - 1;
        int key = 65;
        long startTime = System.nanoTime();
        int result = binarySearch(arr, low, high, key);
        long endTime = System.nanoTime();
        double timeInSeconds = (endTime - startTime) / 1_000_000.0;

        System.out.println(key + " is found at index " + result);
        System.out.println("Time taken: " + timeInSeconds + " milliseconds");
    }
}
