import java.util.Stack;

// Given an array of integers, for each element in the array, find its next greater element in the array.
// The next greater element is the first element towards right, which is greater than the current element.
// If the current element has no next greater element, use -1.
// i.e., Input: arr = {4, 7,  3, 4, 8, 1}
//       Output: arr = {7, 8, 4, 8, -1, -1}
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static void display(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(" | ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 3, 4, 8, 1};

        // Measure time for the nextGreaterElement method
        long startTime = System.currentTimeMillis();
        int[] result = nextGreaterElement(arr);
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        System.out.print("arr:      "); display(arr);
        System.out.println();
        System.out.print("result:   "); display(result);
        System.out.println();
        System.out.println("Time taken: " + timeTaken + " milliseconds");
    }

}
