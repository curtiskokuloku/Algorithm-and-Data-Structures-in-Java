public class RemoveEvenIntegers {
    // Given an array of integers, return an array with even integers removed
    // Input: arr = {3, 2, 4, 7, 10, 6, 5}
    // Output: arr = {3, 7, 5}

    public static int[] removeEven(int[] arr) {
        int oddCount = 0;       // keeps track of odd integers in the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }

        int[] result = new int[oddCount];   // new array of odd integers
        int idx = 0;                        // index into result array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result[idx++] = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrintArray p = new PrintArray();
        int[] arr = {3, 2, 4, 7, 10, 6, 5}; // original array
        p.printArray(arr);

        int[] result = removeEven(arr);     // result array with even number of elements removed
        p.printArray(result);
    }
}
