import java.util.HashSet;
import java.util.Set;

// Given an array of integers, return true if any value appears at least twice in the array;
// Return false otherwise, indicating that every value is distinct.
// i.e., Input: nums = {1, 2, 3, 1}
//       Output: true
//       Input: nums = {1, 2, 3, 4}
//       Output: false
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    public static void display(int[] arr) {
        // Print the elements in the array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n-1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.print("Input: nums = ");
        display(nums);
        System.out.println("Output: " + containsDuplicate(nums));

        nums = new int[]{1, 2, 3, 4};
        System.out.print("Input: nums = ");
        display(nums);
        System.out.println("Output: " + containsDuplicate(nums));

        nums = new int[]{7, 3, 1, 4, 1};
        System.out.print("Input: nums = " + containsDuplicate(nums));
        display(nums);
        System.out.println("Output: " + containsDuplicate(nums));
    }
}
