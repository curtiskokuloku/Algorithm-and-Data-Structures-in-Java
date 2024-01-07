import java.util.LinkedList;
import java.util.Queue;

// Generating a sequence of Binary Numbers from 1 to n using a Queue.
// i.e., Input: n = 3
//       Output: result = {"1", "10", "11"}
//       Input: n = 5
//       Output: result = {"1", "10", "11", "100", "101"}
// This can be treated as a binary tree where every left branch is an even number and every
// right branch is an odd number. For example, let 1 be the root of the tree. The left child of 1
// would be 2 (10 in binary) and the right child would be 3 (11 in binary).
// If we use a pre-order traversal, such that we first visit the root node first, followed by the
// left subtree, and then the right subtree, we will get: 1 --> 10 --> 11 --> ...

public class GenerateBinaryNumbers {
    public static String[] generateBinaryNumbers(int n) {
        if (n == 0) return new String[]{"0"};
        if (n == 1) return new String[]{"1"};
        String[] result = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");   // add 1 to the front of the queue
        for (int i = 0; i < n; i++) {
            result[i] = q.poll();   // get the element from the front of the queue
            String n1 = result[i] + "0";    // left branch
            String n2 = result[i] + "1";    // right branch
            q.offer(n1); q.offer(n2);       // add next numbers to the rear of the queue
        }
        return result;
    }

    public static void display(String[] result) {
        // Print the result
        System.out.print("{");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length-1) System.out.print(", ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        int n = 5;  // result: {"1", "10", "11", "100", "101"}
        System.out.println("Input: n = " + n);
        System.out.print("Output: result = "); display(generateBinaryNumbers(n));
        System.out.println();
        n = 1;  // result: {"1"}
        System.out.println("Input: n = " + n);
        System.out.print("Output: result = "); display(generateBinaryNumbers(n));
        System.out.println();
        n = 0;  // result: {}
        System.out.println("Input: n = " + n);
        System.out.print("Output: result = "); display(generateBinaryNumbers(n));
        System.out.println();
        n = 100;
        System.out.println("Input: n = " + n);
        System.out.print("Output: result = "); display(generateBinaryNumbers(n));
    }
}
