// Given an array of integers sorted in ascending order, return an array of the squares of each
// number sorted in ascending order.
// i.e., Input: arr = {-4, -1, 0, 3, 10}
//       Output: arr = {0, 1, 9, 10, 100}
//       Explanation: After squaring, the array becomes {16, 1, 0, 9, 100}. After sorting, it becomes
//                    {0, 1, 9, 16, 100}. This can be done in O(n) time.
public class SquareSortedArray {
    public static void display(int[] arr) {
        // Print the elements in the array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n-1) System.out.print(", ");
        }
        System.out.println();
    }

    public static int[] sortedSquares(int[] arr, int n) {
        int[] result = new int[n];
        for (int i = 0, j = n-1, k = n-1; k >= 0; k--) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                result[k] = arr[i] * arr[i];
                i++;
            } else {
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        System.out.print("Input: ");
        display(arr);
        int[] result = sortedSquares(arr, arr.length);
        System.out.print("Output: ");
        display(result);
    }
}
