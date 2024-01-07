public class SinglyLinkedListDriver {
    public static void main(String[] args) {    // Demo
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new Node(10);
        Node second = new Node(1);
        Node third = new Node(8);
        Node fourth = new Node(11);

        // Connecting them together to form a chain
        sll.head.next = second;    // 10 --> 1
        second.next = third;       // 10 --> 1 --> 8
        third.next = fourth;       // 10 --> 1 --> 8 --> 11 --> null

        System.out.print("Original list: ");
        sll.display();
        System.out.println("Number of nodes: " + sll.length());

        // Finding the position of node with value 8
        System.out.println("The value 8 is at position: " + sll.positionOf(8));

        // Finding the value of node located at position 2
        System.out.println("The value at position 2 is: " + sll.getValueAtPosition(2));

        // Adding 11 to the beginning of the list
        System.out.println();
        sll.insertAtFirst(11);    // 11 --> 10 --> 1 --> 8 --> 11 --> null
        System.out.print("After inserting 11 to the front: ");
        sll.display();
        System.out.println("Number of nodes is now: " + sll.length());
        System.out.println("The value 8 is now at position: " + sll.positionOf(8));
        System.out.println("The value at position 2 is now: " + sll.getValueAtPosition(2));

        // Adding 4 to the end of the list
        System.out.println();
        sll.insertAtLast(4);       // 11 --> 10 --> 1 --> 8 --> 11 --> 4 --> null
        System.out.print("After inserting 4 to the end: ");
        sll.display();
        System.out.println("Number of nodes is now: " + sll.length());

        // Adding 7 to position 3 in the list (index 2)
        System.out.println();
        sll.insertAtPosition(7, 3); // 11 --> 10 --> 7 --> 1 --> 8 --> 11 --> 4 --> null
        System.out.print("After inserting 7 at position 3: ");
        sll.display();
        System.out.println("Number of nodes is now: " + sll.length());

        // Deleting the first node in the list
        System.out.println();
        Node removedFirst = sll.deleteFirst();
        System.out.println("Value deleted: " + removedFirst.data);
        System.out.print("After deleting the first node: ");    // 10 --> 7 --> 1 --> 8 --> 11 --> 4 --> null
        sll.display();
        System.out.println("Number of nodes is now: " + sll.length());

        // Deleting the last node in the list
        System.out.println();
        Node removedLast = sll.deleteLast();
        System.out.println("Value deleted: " + removedLast.data);
        System.out.print("After deleting the last node: ");    // 10 --> 7 --> 1 --> 8 --> 11 --> null
        sll.display();
        System.out.println("Number of nodes is now: " + sll.length());

        // Deleting the node at position 3
        System.out.println();
        Node removed3 = sll.deleteAtPosition(3);
        System.out.println("Value deleted: " + removed3.data);
        System.out.print("After deleting the node at position 3: ");    // 10 --> 7 --> 8 --> 11 --> null
        sll.display();
        System.out.println("Number of nodes is now: " + sll.length());

        // Finding the middle node in the list
        System.out.println();
        sll.insertAtLast(12);
        sll.insertAtLast(15);
        sll.insertAtLast(12);
        sll.display();  // 10 --> 7 --> 8 --> 11 --> 12 --> 15 --> 12 --> null
        System.out.println("Number of nodes is: " + sll.length());
        Node middle = sll.findMiddle();
        System.out.println("The middle node is: " + middle.data);   // 11

        // Reversing the list
        System.out.println();
        System.out.print("The list reversed: ");
        sll.head = sll.reverse(sll.head);   // 12 --> 15 --> 12 --> 11 --> 8 --> 7 --> 10 --> null
        sll.display();

        // Sorting the list
        System.out.println();
        System.out.print("The list is sorted: ");
        sll.sort();                         // 7 --> 8 --> 10 --> 11 --> 12 --> 12 --> 15 --> null
        sll.display();

        // Removing duplicates from the list; Requires list to be sorted
        System.out.println();
        sll.removeDuplicates();
        System.out.print("After removing duplicates from: ");
        sll.display();  // 7 --> 8 --> 10 --> 11 --> 12 --> 15 --> null
        System.out.println("Size is: " + sll.length());

        // Searching for values 0 and 7 in the list
        System.out.println();
        System.out.println("Is 0 in the list?: " + sll.search(3));  // false
        System.out.println("Is 7 in the list?: " + sll.search(7));  // true

        // Inserting new values into the list, but in sorted order
        System.out.println();
        sll.insertInSortedOrder(13);
        System.out.print("The new list: ");
        sll.display();
        System.out.println("Size is: " + sll.length());

        // Deleting the node with the value 7
        System.out.println();
        sll.removeKey(7);
        System.out.print("After removing the node with the value 7: ");
        sll.display();  // 8 --> 10 --> 11 --> 12 --> 13 --> 15 --> null
        System.out.println("Size is: " + sll.length());

        // Clearing the list
        System.out.println();
        sll.clear();
        System.out.print("List is now empty: ");
        sll.display();
        System.out.println("Size is: " + sll.length());

        // Merging two sorted lists
        System.out.println();
        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertAtLast(1);
        sll1.insertAtLast(4);
        sll1.insertAtLast(8);

        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertAtLast(3);
        sll2.insertAtLast(5);
        sll2.insertAtLast(8);
        sll2.insertAtLast(9);
        sll2.insertAtLast(14);
        sll2.insertAtLast(18);

        System.out.print("List 1: ");
        sll1.display();

        System.out.print("List 2: ");
        sll2.display();

        SinglyLinkedList.merge(sll1.head, sll2.head);
        System.out.print("After merging List 1 and List 2: ");
        sll1.display();
    }
}
