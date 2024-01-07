public class ArrayDemo {
    public void arrayDemo() {
        PrintArray p = new PrintArray();
        System.out.print("First Array: ");
        int[] myArray = new int[5]; // default values
        // p.printArray(myArray);
        myArray[0] = 5;
        myArray[1] = 15;
        myArray[2] = 25;
        myArray[3] = 35;
        myArray[4] = 45;
        // myArray[5] = 55;    // This will produce an error
        p.printArray(myArray);
        System.out.println("Length of array: " + myArray.length);
        System.out.println("Last element: " + myArray[myArray.length - 1]);

        System.out.print("Second Array: ");
        int[] myArray2 = {5, 15, 25, 35, 45, 55, 100};
        p.printArray(myArray2);
    }

    public static void main(String[] args) {
        // Test-driver
        ArrayDemo test = new ArrayDemo();
        test.arrayDemo();
    }
}
