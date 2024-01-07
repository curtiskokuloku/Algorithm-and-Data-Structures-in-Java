// Given a sorted array of distinct integers and a target value,
// return the index if the target is found. If not, return the index where it would be if it was
// inserted in order. The algorithm should run in O(log n) time.
// i.e., Input: arr = {1, 3, 5, 7}, target = 5
//       Output: 2
//       Input: arr = {1, 3, 5, 7}, target = 2
//       Output: 1
//       Input: arr = {1, 3, 5, 7}, target = 8
//       Output: 4
//       Input: arr = {1, 3, 5, 7}, target = 0
//       Output: 0

public class SearchInsertPosition {
    public static int searchInsert(int[] arr, int target) {
        // This algorithm is identical to the binary search algorithm, except that if the target
        // is not found, we return the index of where it would be if it was inserted in order.
        // Runtime of Binary Search algorithm is O(log n)
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void display(int[] arr, int target) {
        System.out.print("Input: {");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("}, target: " + target);
        System.out.println("Output: " + searchInsert(arr, target));
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        int target = 5;
        display(arr, target);

        target = 2;
        display(arr, target);

        target = 8;
        display(arr, target);

        target = 0;
        display(arr, target);

        arr = new int[]{1, 10, 20, 47, 59, 65, 75, 88, 99};
        target = 66;
        display(arr, target);
    }
}
