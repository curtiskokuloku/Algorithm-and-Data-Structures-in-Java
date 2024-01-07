import java.util.EmptyStackException;

// Implementing a Stack using a Singly Linked List
public class StackLinkedList {
    public Node top;  // Top of the stack; Last element added
    public int length;          // Number of elements in the stack

    public StackLinkedList() {
        // Constructor
        top = null;
        length = 0;
    }

    public int getLength() {
        // Return the length of the stack
        return length;
    }

    public boolean isEmpty() {
        // Determine if the stack is empty
        return length == 0 || top == null;
    }

    public void push(int data) {
        // Add a new element on the top of the stack
        Node temp = new Node(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() {
        // Remove and return the element at the top of the stack
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public int peek() {
        // Return the element at the top of the stack
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void display() {
        // Print the elements in the stack
        if (isEmpty()) return;

        Node temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            System.out.println("-----");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        StackLinkedList s = new StackLinkedList();
        s.push(10);
        s.push(15);
        s.push(20);
        s.push(25);
        s.push(30);
        s.display();
        System.out.println();
        System.out.println("Top of the stack is: " + s.peek());
        System.out.println("Length of the stack is: " + s.getLength());
        System.out.println("Removing the top element: " + s.pop());
        System.out.println();

        s.display();
        System.out.println();
        System.out.println("Top of the stack is now: " + s.peek());
        System.out.println("Length of the stack is now: " + s.getLength());
    }

}
