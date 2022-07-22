package binary_search_tree.n01;

public class BinarySearchTree {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("Left  -> Inserted " + value + " to left of " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("Right -> Inserted " + value + " to right of " + node.value);
                node.right = new Node(value);
            }
        }
    }

    //The in-order traversal consists of first visiting the left sub-tree, then the root node, and finally the right sub-tree.
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    //Same as in-order just reversed.
    public void traverseReverseOrder(Node node) {
        if (node != null) {
            traverseReverseOrder(node.right);
            System.out.print(" " + node.value);
            traverseReverseOrder(node.left);
        }
    }

    //In Pre-order traversal you visit the root node first, then the left subtree, and finally the right subtree. Here’s the code.
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    //In Post-order traversal you visit left subtree first, then the right subtree, and the root node at the end. Here’s the code.
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public static void main(String args[]) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = new Node(5);
        System.out.println("-------------------------------------------");

        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.value);
        System.out.println("-------------------------------------------");

        binarySearchTree.insert(root, 2);
        binarySearchTree.insert(root, 4);
        binarySearchTree.insert(root, 8);
        binarySearchTree.insert(root, 6);
        binarySearchTree.insert(root, 7);
        binarySearchTree.insert(root, 3);
        binarySearchTree.insert(root, 9);
        System.out.println("-------------------------------------------");

        System.out.println("Traversing tree in order");
        binarySearchTree.traverseInOrder(root);
        System.out.println();
        System.out.println("-------------------------------------------");

        System.out.println("Traversing tree reverse order");
        binarySearchTree.traverseReverseOrder(root);
        System.out.println();
        System.out.println("-------------------------------------------");

        System.out.println("Traversing tree pre order");
        binarySearchTree.traversePreOrder(root);
        System.out.println();
        System.out.println("-------------------------------------------");

        System.out.println("Traversing tree post order");
        binarySearchTree.traversePostOrder(root);
        System.out.println();
        System.out.println("-------------------------------------------");
    }
}
