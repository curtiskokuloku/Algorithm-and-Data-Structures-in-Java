// Implementation of a Queue using a Singly LinkedList
public class QueueLinkedList {
    public Node front;  // front of the queue; first element added and thus, first to be deleted
    public Node rear;   // end of the queue; last element added and thus, last to be deleted

    public int length;  // number of elements in the queue

    public QueueLinkedList() {
        this.front = null;
        this.rear = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0 || front == null;
    }

    public void display() {
        // Display the structure of the queue
        if (isEmpty()) return;
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void enqueue(int data) {
        // Insert a data at the back of the queue
        Node temp = new Node(data);
        if (isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public int dequeue() {
        // Remove an element from the front of the queue, and return that element
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int result = front.data;
        front = front.next;
        if (front == null) rear = null;
        length--;
        return result;
    }

    public Node getFront() {
        // Return the front of the queue
        return this.front;
    }

    public Node getRear() {
        // Return the rear of the queue
        return this.rear;
    }

    public int getData(Node node) {
        // Return the data at the given node
        if (node == null) throw new IllegalArgumentException("Node must not be null");
        return node.data;
    }

    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(10);
        q.enqueue(11);
        q.enqueue(15);
        q.enqueue(23);
        q.enqueue(5);
        q.enqueue(1);

        System.out.print("Queue: ");
        q.display();

        long startTimeEnqueue = System.nanoTime();
        q.enqueue(100); // Enqueue an element
        long endTimeEnqueue = System.nanoTime();
        long timeTakenEnqueue = (endTimeEnqueue - startTimeEnqueue) / 1_000_000;

        System.out.println("Front of the queue: " + q.getData(q.getFront()));
        System.out.println("Rear of the queue: " + q.getData(q.getRear()));
        System.out.println("Length of the Queue: " + q.length());

        long startTimeDequeue = System.nanoTime();
        int dequeuedElement = q.dequeue(); // Dequeue an element
        long endTimeDequeue = System.nanoTime();
        long timeTakenDequeue = (endTimeDequeue - startTimeDequeue) / 1_000_000;

        System.out.println("Deleted element: " + dequeuedElement);
        System.out.println("Front of the queue: " + q.getData(q.getFront()));
        System.out.println("Length of the Queue: " + q.length());

        System.out.println("Time taken for enqueue: " + timeTakenEnqueue + " milliseconds");
        System.out.println("Time taken for dequeue: " + timeTakenDequeue + " milliseconds");
    }
}
