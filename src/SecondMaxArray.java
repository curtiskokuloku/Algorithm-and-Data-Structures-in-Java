public class SecondMaxArray {
    // Given an array of integers, return the second maximum value in the array.
    // Assume that the second maximum value exists.
    // Input: arr = {12, 34, 2, 34, 33, 1}
    // Output: 33

    public static int findSecondMax(int[] arr) {
        int max = arr[0];
        int secondMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if(arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 2, 34, 33, 1};
        PrintArray p = new PrintArray();
        p.printArray(arr);
        System.out.println("Second Maximum Value: " + findSecondMax(arr));
    }
}
