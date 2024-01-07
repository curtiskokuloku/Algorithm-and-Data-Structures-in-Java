import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Implementation of a Binary Tree
public class BinaryTree {
    public TreeNode root;   // parent node of the tree

    public BinaryTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        // Return the root node of the tree
        return this.root;
    }

    public void setRoot(TreeNode newRoot) {
        // Set the root of the tree to a new node
        this.root = newRoot;
    }

    public boolean isEmpty(TreeNode root) {
        // Check if the tree is empty
        return root == null;
    }

    public int size(TreeNode root) {
        // Count the number of nodes in the tree
        if (isEmpty(root)) return 0;
        return 1 + size(root.getLeft()) + size(root.getRight());
    }

    public int height(TreeNode root) {
        // Get the height of the tree
        if (isEmpty(root)) return 0;
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }

    public void preOrderR(TreeNode root) {
        // Recursive pre-order traversal of a Binary Tree
        if (isEmpty(root)) return;
        System.out.print(root.getData() + " ");
        preOrderR(root.getLeft());
        preOrderR(root.getRight());
    }

    public void preOrderI(TreeNode root) {
        // Iterative pre-order traversal of a Binary Tree, using a stack
        if (isEmpty(root)) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.getData() + " ");
            if (temp.getRight() != null) stack.push(temp.getRight());
            if (temp.getLeft() != null) stack.push(temp.getLeft());
        }
    }

    public void inOrderR(TreeNode root) {
        // Recursive in-order traversal of a Binary Tree
        if (isEmpty(root)) return;
        inOrderR(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrderR(root.getRight());
    }

    public void inOrderI(TreeNode root) {
        // Iterative in-order traversal of a Binary Tree, using a stack
        if (isEmpty(root)) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            } else {
                temp = stack.pop();
                System.out.print(temp.getData() + " ");
                temp = temp.getRight();
            }
        }
    }

    public void postOrderR(TreeNode root) {
        // Recursive post-order traversal of a Binary Tree
        if (isEmpty(root)) return;
        postOrderR(root.getLeft());
        postOrderR(root.getRight());
        System.out.print(root.getData() + " ");
    }

    public void postOrderI(TreeNode root) {
        // Iterative post-order traversal of a Binary Tree
        if (isEmpty(root)) return;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                TreeNode temp = stack.peek().getRight();
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.getData() + " ");
                    while (!stack.isEmpty() && temp == stack.peek().getRight()) {
                        temp = stack.pop();
                        System.out.print(temp.getData() + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public void levelOrderI(TreeNode root) {
        // Iterative level order traversal of a Binary tree
        if (isEmpty(root)) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.getData() + " ");
            if (temp.getLeft() != null) {
                q.offer(temp.getLeft());
            }
            if (temp.getRight() != null) {
                q.offer(temp.getRight());
            }
        }
    }

    public void createBinaryTree() {
        // Create a Binary Tree with 5 nodes and 1 being the root
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);

        setRoot(first);         // root --> first

        first.setLeft(second);
        first.setRight(third);  // second <-- first --> third

        second.setLeft(fourth);
        second.setRight(fifth); // fourth <-- second --> fifth

        third.setLeft(sixth);
        third.setRight(seventh); // sixth <-- third --> seventh
    }

    public int findMaxHelper(TreeNode root) {
        // Helper function used to find the maximum value in a tree
        if (isEmpty(root)) return Integer.MIN_VALUE;
        int result = root.getData();
        int left = findMaxHelper(root.getLeft());
        int right = findMaxHelper(root.getRight());

        if (left > right) result = left;
        if (right > result) result = right;

        return result;
    }

    public int findMax() {
        // Find the maximum value in a Binary tree Recursively
        return findMaxHelper(getRoot());
    }

    public int makeArray(TreeNode root, int[] arr, int i) {
        // Convert a Binary tree into an array recursively; useful for flattening a Binary Tree
        if (root == null) return i;
        arr[i] = root.getData();
        i = makeArray(root.getLeft(), arr, i+1);
        i = makeArray(root.getRight(), arr, i);
        return i;
    }

    public int[] flatten(TreeNode root) {
        // Flatten a Binary Tree into a sorted array
        int size = size(root);
        int[] flattenedArray = new int[size];
        makeArray(root, flattenedArray, 0);
        return flattenedArray;
    }

    public void displayArray(int[] arr) {
        // Display the flattened array of the Binary Tree
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length-1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree();

        System.out.println("Root of the tree is " + tree.getRoot().getData());
        System.out.println("Size of the tree is " + tree.size(tree.getRoot()));
        System.out.println("Height of the tree is " + tree.height(tree.getRoot()));

        System.out.print("Pre-order: ");
        tree.preOrderR(tree.getRoot());    // 1 2 4 5 3 6 7
        System.out.println();

        System.out.print("In-order: ");
        tree.inOrderR(tree.getRoot());    // 4 2 5 1 6 3 7
        System.out.println();

        System.out.print("Post-order: ");
        tree.postOrderI(tree.getRoot());    // 4 5 2 6 7 3 1
        System.out.println();

        System.out.print("Level-order : ");
        tree.levelOrderI(tree.getRoot());    // 1 2 3 4 5 6 7
        System.out.println();

        System.out.println("Maximum value: " + tree.findMax());

        int[] flattenedTree = tree.flatten(tree.getRoot());
        System.out.print("Flattened tree: ");
        tree.displayArray(flattenedTree);
    }
}
