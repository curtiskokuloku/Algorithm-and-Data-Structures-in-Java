// Dutch National Flag Problem
// Given an array containing only 0's, 1's, and 2's, sort the array in linear time (O(n))
// and constant space (O(1)).
// i.e., Input:  arr = {2, 0, 2, 2, 0, 1, 1}
//       Output: arr = {0, 0, 1, 1, 2, 2, 2}
public class SortArrayOf012 {
    public static void display(int[] arr) {
        // Print the elements in the array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n-1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void sort012(int[] arr) {
        int k = arr.length-1;
        int i = 0, j = 0;
        while (i <= k) {
            if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, k);
                k--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 2, 0, 1, 1};
        System.out.print("Input: ");
        display(arr);
        System.out.print("Output: ");
        sort012(arr);
        display(arr);
    }
}
