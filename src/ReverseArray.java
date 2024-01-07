public class ReverseArray {
    // Given an array of integers, the task is to reverse the integers in the array
    // Input: arr = {2, 11, 5, 10, 7, 8}
    // Output: arr = {8, 7, 5, 10, 11, 2}

    public static void reverseArray(int[] arr, int start, int end) {
        // 'start' and 'end' are the range between which we want to reverse the array
        // We will swap two values as start pointer is smaller than the end pointer
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;    // increase 'start' pointer
            end--;      // decrease 'end' pointer
        }
    }

    public static void main(String[] args) {
        PrintArray p = new PrintArray();
        int[] arr = {2, 11, 5, 10, 7, 8};
        System.out.print("Original: ");
        p.printArray(arr);

        System.out.print("Reversed: ");
        reverseArray(arr, 0, arr.length-1);
        p.printArray(arr);
    }
}
