public class ResizeArray {
    // Given an array of a fixed size, resize the array so that the size of the new array is more than
    // the size of the original array. The new array must contain the elements of the original array
    // in the same order.
    // Input: arr = {5, 9, 3, 10}, capacity = 8
    // Output: {5, 9, 3, 10, 0, 0, 0, 0}; 0 represent the presence of null elements

    public static int[] resize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    public static void main(String[] args) {
        PrintArray p = new PrintArray();
        int[] arr = {5, 9, 3, 10};
        int capacity = arr.length * 2;
        System.out.print("arr: ");
        p.printArray(arr);
        System.out.println("capacity: " + capacity);
        arr = resize(arr, capacity);
        p.printArray(arr);
    }
}
