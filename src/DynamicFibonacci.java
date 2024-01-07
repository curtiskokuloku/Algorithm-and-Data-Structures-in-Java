// Implementation of Fibonacci Number in Dynamic Programming
public class DynamicFibonacci {
    public static int fibRecursive(int n) {
        // Original implementation of fibonacci using Recursion
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    public static int bottomUpFib(int n) {
        // Bottom-up approach of fibonacci using iteration and a table to store smaller sub-problems
        int[] table = new int[n+1];
        if (n == 0) return 0;
        table[0] = 0;   // fib(0) = 0
        table[1] = 1;   // fib(1) = 1
        for (int i = 2; i <= n; i++) table[i] = table[i-1] + table[i-2];
        return table[n];
    }

    public static int topDownFib(int[] memo, int n) {
        // Top-down approach of fibonacci that memorizes solutions of sub-problems and reuses it if necessary
        if (memo[n] == 0) { // solution is not yet stored into memo
            if (n <= 1) {
                memo[n] = n;
            } else {
                memo[n] = topDownFib(memo, n-1) + topDownFib(memo, n-2);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 6;
        // Time measurement for the Recursive Fibonacci implementation
        long startTimeRecursive = System.nanoTime();
        int fibRecursiveResult = fibRecursive(n);
        long endTimeRecursive = System.nanoTime();
        long timeTakenRecursive = endTimeRecursive - startTimeRecursive;
        double timeInSecondsRecursive = timeTakenRecursive / 1_000_000.0;

        // Time measurement for the Bottom-Up Fibonacci implementation
        long startTimeBottomUp = System.nanoTime();
        int bottomUpFibResult = bottomUpFib(n);
        long endTimeBottomUp = System.nanoTime();
        long timeTakenBottomUp = endTimeBottomUp - startTimeBottomUp;
        double timeInSecondsBottomUp = timeTakenBottomUp / 1_000_000.0;

        // Time measurement for the Bottom-Up Fibonacci implementation
        int[] memo = new int[n+1];
        long startTimeTopDown = System.nanoTime();
        int TopDownFibResult = topDownFib(memo, n);
        long endTimeTopDown = System.nanoTime();
        long timeTakenTopDown = endTimeTopDown - startTimeTopDown;
        double timeInSecondsTopDown = timeTakenTopDown / 1_000_000.0;

        System.out.println("fibRecursive(" + n + ") = " + fibRecursiveResult);
        System.out.println("Time taken by Recursive Fibonacci: " + timeInSecondsRecursive + " milliseconds");

        System.out.println("bottomUpFib(" + n + ") = " + bottomUpFibResult);
        System.out.println("Time taken by Bottom-Up Fibonacci: " + timeInSecondsBottomUp + " milliseconds");

        System.out.println("TopDownFib(" + n + ") = " + TopDownFibResult);
        System.out.println("Time taken by Bottom-Up Fibonacci: " + timeInSecondsTopDown + " milliseconds");
    }
}
