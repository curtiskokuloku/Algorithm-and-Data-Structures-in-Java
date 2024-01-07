// Represents a Binary Search Tree (BST)

public class BinarySearchTree{

    public TreeNode root;

    public TreeNode getRoot() {
        // Return the root node of the BST
        return this.root;
    }

    public boolean isEmpty(TreeNode root) {
        // Determine if the BST is empty
        return root == null;
    }

    public int size(TreeNode root) {
        // Count the number of nodes in the BST
        if (isEmpty(root)) return 0;
        return 1 + size(root.getLeft()) + size(root.getRight());
    }

    public int height(TreeNode root) {
        // Get the height of the BST
        if (isEmpty(root)) return 0;
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }

    public void print(TreeNode root) {
        // Display the BST in an in-order fashion: left subtree, root, right subtree
        if (isEmpty(root)) return;
        print(root.getLeft());
        System.out.print(root.getData() + " ");
        print(root.getRight());
    }

    public TreeNode insertHelper(TreeNode root, int value) {
        // Helper function to insert a value in a BST
        if (isEmpty(root)) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.getData()) {
            root.setLeft(insertHelper(root.getLeft(), value));
        } else {
            root.setRight(insertHelper(root.getRight(), value));
        }
        return root;
    }

    public void insert(int value) {
        root = insertHelper(root, value);
    }

    public TreeNode search(int key) {
        // Search if a given key is present in the BST
        return searchHelper(root, key);
    }

    public TreeNode searchHelper(TreeNode root, int key) {
        // Helper function to search if a given key is present in the BST
        if (isEmpty(root) || root.getData() == key) return root;
        if (key < root.getData()) {
            return searchHelper(root.getLeft(), key);
        } else return searchHelper(root.getRight(), key);
    }

    public boolean doesExist(TreeNode root, int key) {
        // Determine if a given key is present in the BST
        return search(key) != null;
    }

    public boolean isValid(TreeNode root, long min, long max) {
        // Given the root of a Binary Tree, Determine if it is a valid binary search tree
        // Consider the interval {min, max}:
        // - If you go towards left subtree, min remains the same & max changes to parent value
        // - If you go towards right subtree, max remains the same & min changes to parent value
        if (isEmpty(root)) return true;
        if (root.getData() <= min || root.getData() >= max) return false;
        boolean left = isValid(root.getLeft(), min, root.getData());
        if (left) {
            boolean right = isValid(root.getRight(), root.getData(), max);
            return right;
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(8);
        bst.insert(9);
        bst.insert(2);
        bst.insert(6);

        System.out.print("BST in in-order fashion: ");
        bst.print(bst.getRoot());
        System.out.println();
        System.out.println("Root of the BST is " + bst.getRoot().getData());

        // Measure time for height() method
        long startTimeHeight = System.nanoTime();
        int height = bst.height(bst.getRoot());
        long endTimeHeight = System.nanoTime();
        long timeTakenHeight = endTimeHeight - startTimeHeight;
        System.out.println("Height of the BST is " + height);
        System.out.println("Time taken for height() method: " + timeTakenHeight / 1000000.0 + " milliseconds");

        // Measure time for size() method
        long startTimeSize = System.nanoTime();
        int size = bst.size(bst.getRoot());
        long endTimeSize = System.nanoTime();
        long timeTakenSize = endTimeSize - startTimeSize;
        System.out.println("Number of nodes in the BST is " + size);
        System.out.println("Time taken for size() method: " + timeTakenSize / 1000000.0 + " milliseconds");

        // Measure time for doesExist() method
        long startTimeDoesExist = System.nanoTime();
        boolean doesExist = bst.doesExist(bst.getRoot(), 3);
        long endTimeDoesExist = System.nanoTime();
        long timeTakenDoesExist = endTimeDoesExist - startTimeDoesExist;
        System.out.println("Does 3 exist in the BST? " + doesExist);
        System.out.println("Time taken for doesExist() method: " + timeTakenDoesExist / 1000000.0 + " milliseconds");

        // Measure time for isValid() method
        long startTimeIsValid = System.nanoTime();
        boolean isValid = bst.isValid(bst.getRoot(), Long.MIN_VALUE, Long.MAX_VALUE);
        long endTimeIsValid = System.nanoTime();
        long timeTakenIsValid = endTimeIsValid - startTimeIsValid;
        System.out.println("Is the BST valid? " + isValid);
        System.out.println("Time taken for isValid() method: " + timeTakenIsValid / 1000000.0 + " milliseconds");
    }

}
