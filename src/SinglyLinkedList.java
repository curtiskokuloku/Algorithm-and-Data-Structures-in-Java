// Representation of a Singly Linked List
public class SinglyLinkedList {
    public Node head;
    public int numNodes;

    public void insertAtFirst(int value) {
        // Inserting a node at the beginning of a singly linked list
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void insertAtLast(int value) {
        // Inserting a node at the end of a singly linked list
        Node newNode = new Node(value);
        if (head == null) { // List is empty, so insert value to head
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        numNodes++;
    }

    public void insertAtPosition(int value, int position) {
        // Inserting a node at a given position index
        // Assuming position to be valid and starting from 1 (1 being the beginning)
        if (position > numNodes + 1 || position <= 0) {
            System.out.println("Position is out of bounds.");
            return;
        } else if (position == 1) {
            insertAtFirst(value);
        } else {
            Node newNode = new Node(value);
            Node previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            newNode.next = previous.next;
            previous.next = newNode;
            numNodes++;
        }
    }

    public Node findMiddle() {
        // Finds the middle node in a Singly Linked List.
        if (head == null) {
            return null;
        }
        int n = numNodes;
        int i = 1;
        Node current = head;
        if (n % 2 == 0) {   // Case 1: List has an even number of nodes
            n /= 2;
        } else {            // Case 2: List has an odd number of nodes
            n = (n/2) + 1;
        }
        while (i < n && current != null) {
            current = current.next;
            i++;
        }
        return current;
    }

    public Node findMiddleOptimized() {
        // A more efficient way to find the middle node in a Singly Linked List
        if (head == null) {
            return null;
        }
        Node slowPtr = head, fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public Node deleteFirst() {
        // Deletes the first node in the list and return that node
        if (head == null) { // there are no node to delete
            return null;
        }
        Node temp = head;
        head = head.next;   // assign head to the next node
        temp.next = null;   // disconnect first node from rest of the list
        numNodes--;
        return temp;
    }

    public Node deleteLast() {
        // Deletes the last node in the list and return that node
        if (head == null || head.next == null) { // there are no nodes
            return head;
        }
        Node current = head;
        Node previous = null;
        while(current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        numNodes--;
        return current;
    }

    public Node deleteAtPosition(int position) {
        // Deletes a node from the list at a given position, and returns that node
        // Assuming position to be valid and starting from 1 (1 is the first node)
        if (position == 1) {
            return deleteFirst();
        } else if(position == numNodes) {
            return deleteLast();
        } else {
            Node previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            previous.next = previous.next.next;
            return current;
        }
    }

    public void removeKey(int key) {
        // Deletes a node from the list with the given key
        if (head == null) {
            System.out.println("Nothing to delete.");
            return;
        }
        Node current = head;
        Node temp = null;

        if (current.data == key) {
            // handling the case where the head contains the key
            head = current.next;
            return;
        }
        while(current != null && current.data != key) {
            temp = current;
            current = current.next;
        }
        if (current == null) return;
        temp.next = current.next;
    }

    public boolean search(int searchKey) {
        // Determines whether a value (key) is in the list
        Node current = head;
        while (current != null) {
            if (searchKey == current.data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeDuplicates() {
        // Removes duplicate nodes from a Singly Linked List
        // Having the list sorted can improve performance
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null && current.next != null) {
            if (equals(current, current.next)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public boolean equals(Node node1, Node node2) {
        // Helper method to check if two nodes have the same value
        return node1.data == node2.data;
    }

    public void insertInSortedOrder(int value) {
        // Given a sorted list, insert a new node that maintains the ordering of the list
        Node newNode = new Node(value);
        if (head == null) {
            return;
        }
        Node current = head;
        Node temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        assert temp != null;
        temp.next = newNode;
    }

    public void display(){
        // Prints the nodes in the list onto console
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;     // get next node
        }
        System.out.println("null");     // end of list
    }

    public int length() {
        // Count the number of nodes in the list
        if (head == null) { // no nodes in the list
            return 0;
        }
        int count = 0;
        Node current = head;
        while(current != null) {    // traverse until at the end of list (when data is null)
            count++;
            current = current.next;
        }
        numNodes = count;
        return numNodes;
    }

    public int getValueAtPosition(int position) {
        // Gets the Node at the given position. Return -1 of position is invalid.
        if (position < 0 || position > numNodes) {
            return -1;
        }
        Node current = head;
        int i = 1;
        while (i < position) {
            current = current.next;
            i++;
        }
        return current.data;
    }

    public int positionOf(int value) {
        // Gets the position of a node with the given value. Returns -1 if node does not exist
        int i = 1;
        Node current = head;
        while(current != null) {
            if (current.data == value) {
                return i;
            }
            i++;
            current = current.next;
        }
        return -1;
    }

    public Node reverse(Node node) {
        // Reverses a singly Linked List
        if (node == null) {
            return null;
        }
        Node current = node;
        Node next = null;
        Node previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public void clear() {
        // Deletes all nodes in the list
        head = null;
        numNodes = 0;
    }

    public void swap(Node a, Node b) {
        // Swaps the values of two nodes
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    public void sort() {
        // Sorts a singly linked list using selection sort
        Node previous = head;
        while (previous.next != null) {
            Node min = previous;
            Node current = previous.next;
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

    public static Node merge(Node a, Node b) {
        // Interview question: Given two sorted singly linked lists, merge them so that the resulting
        // singly linked list is also sorted.
        // Input: 1 --> 3 --> 5 --> null, 2 --> 4 --> 6 --> null
        // Output: 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> null
        Node dummy = new Node(0);
        Node tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }
        return dummy.next;
    }
}
