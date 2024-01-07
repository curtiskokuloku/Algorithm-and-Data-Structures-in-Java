// Merges two sorted arrays together
public class MergeSortedArrays {

    public static void display(int[] arr) {
        // Print the elements in the array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n-1) System.out.print(", ");
        }
        System.out.println();
    }
    public static int[] merge(int[] arr1, int[] arr2, int n, int m) {
        // Merge two sorted arrays together to form a new sorted array of n+m integers
        int[] result = new int[n+m];
        int i = 0, j = 0, k = 0;    // i traverse arr1, j traverse arr2, k traverse result
        while (i < n && j < m) {    // boundary conditions
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < n) { // left over from arr1
            result[k++] = arr1[i++];
        }
        while (j < m) { // left over from arr2
            result[k++] = arr2[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 5, 7};
        int[] arr2 = {3, 4, 9};
        System.out.print("arr1: "); display(arr1);
        System.out.print("arr2: "); display(arr2);

        int n = arr1.length;
        int m = arr2.length;
        int[] result = merge(arr1, arr2, n, m);
        System.out.print("result: ");   display(result);
    }
}
