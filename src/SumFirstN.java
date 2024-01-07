public class SumFirstN {
    // Two algorithms to find the sum of first n natural numbers
    // Input :- n = 4
    // Output :- 10 i.e. (1 + 2 + 3 + 4)

    public int findSum1(int n) {
        // Using the mathematical formula
        // This is a more efficient algorithm because we directly place n into the formula
        return n * (n + 1) / 2;         // 5 steps
                                        // Time taken: T(n) = 5 ==> O(1)
    }

    public int findSum2(int n) {
        // Using the steps to find the sum with a for-loop
        // The time taken by this algorithm would be somewhat more than the first algorithm
        // This is because the for-loop execution depends on n, the input number
        int sum = 0;                    // 1 step
        for (int i = 1; i <= n; i++) {  // 1 + 3(n + 1) + 3n ==> 6n + 4 steps
            sum = sum + i;              // 4n steps
        }
        return sum;                     // 2 steps
                                        // Time taken: T(n) = 1 + 6n + 4 + 4n + 2 ==> O(n)
    }

    public static void main(String[] args) {
        // Test-driver to find the time complexity using built-in functions
        double start, end;

        // findSum1()
        start = System.currentTimeMillis();
        SumFirstN test = new SumFirstN();
        System.out.println("Sum1: " + test.findSum1(9999));
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");

        // findSum2()
        start = System.currentTimeMillis();
        System.out.println("Sum2: " + test.findSum2(9999));
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
    }
}
