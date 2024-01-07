public class FindMissingNum {
    // Given an array of n-1 distinct numbers in the range of 1 to n.
    // Find the missing number in the array.
    // Input: arr = {2, 4, 1, 8, 6, 3, 7}, n = 8
    // Output: 5
    // Explanation: The missing number from range 1 to 8 is 5.

    public static int findMissingNumber(int[] arr, int n) {
        // Mathematical Approach: sum from 1 to n = n(n+1)/n
        int sum = n * (n + 1) / 2;
        System.out.println("Current sum: " + sum);
        for (int i : arr) {
            sum = sum - i;
            System.out.println("Current sum: " + sum);
        }
        return sum;
    }


    public static void main(String[] args) {
        PrintArray p = new PrintArray();
        int[] arr = {2, 4, 1, 8, 6, 3, 7};
        int n = arr.length + 1;
        p.printArray(arr);
        System.out.println("The missing number is " + findMissingNumber(arr, n));
    }
}
