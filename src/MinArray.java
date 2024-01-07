public class MinArray {
    // Given an array of integers, the task is to find the minimum value in the array
    // Input: arr = {5, 9, 3, 15, 1, 2}
    // Output: 1
    public static int findMin(int[] arr) {
        // edge case
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int min = arr[0];       // assigns 'min' to be the first element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) { // compare next element with 'min' value
                min = arr[i];   // reassign 'min' to be the current element
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 15, 1, 2};
        PrintArray p = new PrintArray();
        p.printArray(arr);
        System.out.println("Min Value: " + findMin(arr));
    }
}
