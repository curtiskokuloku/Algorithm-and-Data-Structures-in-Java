public class MoveZerosArray {
    // Given an array of integers, the task is to move all 0's to the end of the array
    // while maintaining the relative order of the non-zero elements
    // Input: arr = {0, 1, 0, 4, 12}
    // Output: arr = {1, 4, 12, 0, 0}

    public static void moveZeros(int[]arr, int n) {
        int i = 0;  // focus in non-zero elements
        int j = 0;  // focus on zeroth elements

        for (; i < n; i++) {    // i and j always increase
            if (arr[i] != 0 && arr[j] == 0) {
                // swap if the ith element not 0 and the jth element is 0
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0) {  // check if the jth element is not 0 and increment 'j'
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 4, 12};
        PrintArray p = new PrintArray();
        p.printArray(arr);
        moveZeros(arr, arr.length);
        p.printArray(arr);
    }
}
