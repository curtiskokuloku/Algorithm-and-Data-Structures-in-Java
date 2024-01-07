// Representation of a Doubly Linked List
public class DoublyLinkedList {
    public DoublyListNode head;     // First node in the list
    public DoublyListNode tail;     // Last node in the list
    public int length;              // Count of number of nodes in the list

    public DoublyLinkedList() {
        // Constructor to initialize the DoublyLinkedList
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        // Determine whether the list is empty or not
        return length == 0 || head == null;
    }

    public int length() {
        // Return the length of the list
        return length;
    }

    public void printListForward() {
        // Print the elements of a Doubly Linked List in Forward direction
        if (isEmpty()) return;
        DoublyListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printListBackward() {
        // Print the elements of a Doubly Linked List in Backward direction
        if (isEmpty() || tail == null) {
            return;
        }
        DoublyListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public void printListAll() {
        // Print the elements of a Doubly Linked List in both direction
        DoublyListNode temp = head;
        while (temp != null) {
            String previousData = (temp == head) ? "null" : "  " + temp.previous.data;
            String nextData = (temp.next == null) ? "null" : " " + temp.next.data;

            System.out.println(previousData + " <-- " + temp.data + " --> " + nextData);
            temp = temp.next;
        }
    }

    public void addFirst(int value) {
        // Insert a node at the beginning of a Doubly Linked List
        DoublyListNode newNode = new DoublyListNode(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void addLast(int value) {
        // Insert a node at the end of a Doubly Linked List
        DoublyListNode newNode = new DoublyListNode(value);
        if(isEmpty()){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void addAt(int value, int position) {
        // Insert a node at the given position in a Doubly Linked List
        DoublyListNode newNode = new DoublyListNode(value);
        if (isEmpty() || position <= 0 || position > length() + 1) {
            return;
        } else if (position == 1) {
            addFirst(value);
        } else if (position == length() + 1) {
            addLast(value);
        } else {
            DoublyListNode ptr = head;
            int i = 1;
            while (i < position - 1) {
                ptr = ptr.next;
                i++;
            }
            newNode.next = ptr.next;
            newNode.previous = ptr;
            ptr.next.previous = newNode;
            ptr.next = newNode;
            length++;
        }
    }

    public int getData(int position) {
        // Return the value of the node at the given position
        if (isEmpty() || position < 0 || position > length()) {
            return -1;
        }
        DoublyListNode ptr = head;
        int i = 1;
        while (i < position) {
            ptr = ptr.next;
            i++;
        }
        return (ptr == null) ? 0 : ptr.data;
    }

    public int positionOf(int value) {
        // Return the position of a node with the given value
        if (isEmpty()) return -1;
        int i = 1;
        DoublyListNode current = head;
        while(current != null) {
            if (current.data == value) {
                return i;
            }
            i++;
            current = current.next;
        }
        return -1;
    }

    public DoublyListNode deleteFist() {
        // Delete the first node in a Doubly Linked List
        if (isEmpty()) return null;
        DoublyListNode temp = head;
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public DoublyListNode deleteLast() {
        // Delete the last node in a Doubly Linked List
        if (isEmpty()) return null;
        DoublyListNode ptr1 = head;
        DoublyListNode ptr2 = null;
        while(ptr1.next != null) {
            ptr2 = ptr1;
            ptr1 = ptr1.next;
        }
        ptr2.next = null;
        length--;
        return ptr1;
    }

    public DoublyListNode delete(int position) {
        // Delete a node at the given position
        if (position == 1) {
            return deleteFist();
        } else if (position == length) {
            return deleteLast();
        } else {
            DoublyListNode previous = head;
            int i = 1;
            while (i < position - 1) {
                previous = previous.next;
                i++;
            }
            DoublyListNode current = previous.next;
            previous.next = previous.next.next;
            length--;
            return current;
        }
    }

    public DoublyListNode reverse(DoublyListNode node) {
        // Reverse a Doubly Linked List
        if (isEmpty() || node == null) {
            return null;
        }
        DoublyListNode current = head;
        DoublyListNode next = null;
        DoublyListNode previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public void removeDuplicates() {
        // Removes duplicate nodes from a Doubly Linked List
        if (isEmpty()) {
            return;
        }
        DoublyListNode ptr = head;
        while (ptr != null && ptr.next != null) {
            if (equals(ptr, ptr.next)) {
                ptr.next = ptr.next.next;
                length--;
            } else {
                ptr = ptr.next;
            }
        }
    }

    public boolean equals(DoublyListNode node1, DoublyListNode node2) {
        // Helper method to check if two nodes have the same value
        return node1.data == node2.data;
    }

    public void swap(DoublyListNode a, DoublyListNode b) {
        // Swaps the values of two nodes
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    public void sort() {
        // Sorts a singly linked list using selection sort
        DoublyListNode previous = head;
        while (previous.next != null) {
            DoublyListNode min = previous;
            DoublyListNode current = previous.next;
            while (current != null) {
                if (current.data < min.data) {
                    min = current;
                }
                current = current.next;
            }
            if (min != previous) {
                swap(previous, min);
            }
            previous = previous.next;
        }
    }

    public void clear() {
        // Remove every node from a Doubly Linked List
        head = tail = null;
        length = 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addLast(1);
        dll.addLast(10);
        dll.addLast(15);
        dll.addLast(25);
        dll.addLast(2);

        dll.addFirst(25);
        dll.addFirst(6);

        dll.addAt(77, 2);
        dll.addAt(6, 8);

//        dll.head = dll.reverse(dll.head);
        System.out.print("List forward: "); dll.printListForward();
        System.out.print("List sorted: "); dll.sort(); dll.printListForward();
        System.out.print("List with no duplicates: "); dll.removeDuplicates(); dll.printListForward();
        System.out.println("Length: " + dll.length());

//        System.out.println("Node at position 1: " + dll.getData(1));
//        System.out.println("Last node: " + dll.getData(dll.length()));
//        System.out.println("23 located at position: " + dll.positionOf(23));
//        System.out.println("First node deleted: " + dll.deleteFist().data);
//        System.out.println("Last node deleted: " + dll.deleteLast().data);
//        System.out.println("Deleting node at position 5: " + dll.delete(5).data);

//        dll.clear();
    }
}
