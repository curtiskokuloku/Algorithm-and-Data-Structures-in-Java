// Represents a node in a Binary Tree
// null <-- left <-- data --> right --> null
public class TreeNode {
    public int data; // Generic type
    public TreeNode left;   // left child of the node
    public TreeNode right;  // right child of the node

    public TreeNode(int data) {
        // Constructor
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public int getData() {
        return this.data;
    }

    public void setData(TreeNode oldNode, int newData) {
        oldNode.data = newData;
    }

    public void setLeft(TreeNode newNode) {
        this.left = newNode;
    }

    public void setRight(TreeNode newNode) {
        this.right = newNode;
    }
}
