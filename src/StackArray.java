// Implementing a Stack using an Array
public class StackArray {
    public int top; // Top of the stack; Last element added
    public int[] arr; // Array of elements added to the stack

    public StackArray(int capacity) {
        // Constructor
        top = -1;
        arr = new int[capacity];
    }

    public StackArray() {
        // Default constructor; creates a new stack with capacity of 10
        this(10);
    }

    public boolean isEmpty() {
        // Determine if the stack is empty
        return top <= -1;
    }

    public boolean isFull() {
        // Determine if the stack is full
        return arr.length == size();
    }

    public int size() {
        // Return the size/length of the stack
        return top + 1;
    }

    public void push(int data) {
        // Add a new element on the top of the stack
        if (isFull()) {
            throw new RuntimeException("Stack overflow!");
        }
        top++;
        arr[top] = data;
    }

    public int pop() {
        // Remove and return the element at the top of the stack
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow!");
        }
        int result = arr[top];
        top--;
        return result;
    }

    public int peek() {
        // Return the element at the top of the stack
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow!");
        }
        return arr[top];
    }

    public void display() {
        // Print the elements in the stack
        int i = top-size()+1;
        while (i <= top) {
            System.out.print(arr[i++]);
            if (i < top+1) System.out.print(" | ");
        }
    }

    public static void main(String[] args) {
        StackArray s = new StackArray(5);
        s.push(34);
        s.push(4);
        s.push(64);
        s.push(78);
        s.push(9);
        s.display();
        System.out.println();
        System.out.println("top of the stack: " + s.peek());    // last element added
        System.out.println("Is stack full: " + s.isFull());
    }
}
