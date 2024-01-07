// This file consists of solutions to several Leetcode problems
public class AddTwoNumbers {

    public void printList(Node node) {
        // Prints the nodes in the list
        Node current = node;
        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;     // get next node
        }
        System.out.println("null");     // end of list
    }

    public Node addTwoNumbers(Node a, Node b) {
        // Given two non-empty linked lists representing two non-negative integers.
        // The digits are stored in reverse order, and each of their nodes contains a single digit.
        // Add the two numbers and return the sum as a linked list.
        // You may assume the two numbers do not contain any leading zero, except the number 0 itself.
        // Example: a = 3 --> 4 --> 3 --> null
        //          b = 5 --> 6 --> 4 -->
        //          result = 8 --> 0 -- > 8 --> null (because 343 + 465 = 808)
        Node dummy = new Node(0);
        Node tail = dummy;
        int carry = 0, result = 0;
        while (a != null && b != null) {
            int sum = carry + a.data + b.data;
            carry = sum / 10;
            result = sum % 10;
            tail.next = new Node(result);
            tail = tail.next;
            a = a.next;
            b = b.next;
        }
        if (carry > 0) tail.next = new Node(carry);
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("Add Two Numbers: " + "\n" + "----------------");
        SinglyLinkedList s1 = new SinglyLinkedList();
        s1.insertAtLast(3);
        s1.insertAtLast(4);
        s1.insertAtLast(3);

        SinglyLinkedList s2 = new SinglyLinkedList();
        s2.insertAtLast(5);
        s2.insertAtLast(6);
        s2.insertAtLast(4);

        s1.display();
        s2.display();

        AddTwoNumbers test = new AddTwoNumbers();
        Node result = test.addTwoNumbers(s1.head, s2.head);

        System.out.print("Result: ");
        test.printList(result);
    }
}