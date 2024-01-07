public class Print3Avg {
    public void findAvg(int a, int b, int c) {
        // An algorithm to print the average of 3 given numbers
        // Runtime :- O(1)
        int sum = a + b + c;
        int avg = sum / 3;
        System.out.println(avg);
    }

    public static void main(String[] args) {
        // Test-driver
        Print3Avg test = new Print3Avg();
        test.findAvg(1, 2, 3);
    }
}
