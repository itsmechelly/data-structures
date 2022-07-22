package binary_search_tree.n02;

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

    public Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
            System.out.println(value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    //1st case - when the node is a leaf node:
    //delete when a node has no children – this is the simplest case,
    //we just need to replace this node with null in its parent node.
    private Node deleteNodeHasNoChild(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
        }
        if (value < current.value) {
            current.left = deleteNodeHasNoChild(current.left, value);
            return current;
        }
        current.right = deleteNodeHasNoChild(current.right, value);
        return current;
    }

    //2nd case - when the node has one child:
    //a node has exactly one child – in the parent node, we replace this node with its only child.
    private Node deleteNodeHasOneChild(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
        }
        if (value < current.value) {
            current.left = deleteNodeHasOneChild(current.left, value);
            return current;
        }
        current.right = deleteNodeHasOneChild(current.right, value);
        return current;
    }

    //3rd case - the node has two children:
    //a node has two children – this is the most complex case because it requires a tree reorganization.
    private Node deleteNodeWithTwoChildren(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            //todo - this approach wrong - need to recode it!
//            int smallestValue = findSmallestValue(current.right);
//            current.value = smallestValue;
//            current.right = deleteNodeWithTwoChildren(current.right, smallestValue);
//            return current;
        }
        if (value < current.value) {
            current.left = deleteNodeWithTwoChildren(current.left, value);
            return current;
        }
        current.right = deleteNodeWithTwoChildren(current.right, value);
        return current;
    }

    //todo - this approach wrong - need to recode it!
    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public static void main(String args[]) {

        BinarySearchTree binaryTree = new BinarySearchTree();
        Node root = new Node(5);
        System.out.println("-------------------------------------------");

        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.value);
        System.out.println("-------------------------------------------");

        binaryTree.addRecursive(root, 2);
        binaryTree.addRecursive(root, 4);
        binaryTree.addRecursive(root, 8);
        binaryTree.addRecursive(root, 6);
        binaryTree.addRecursive(root, 7);
        binaryTree.addRecursive(root, 3);
        binaryTree.addRecursive(root, 9);
        System.out.println("-------------------------------------------");

        System.out.println("Traversing tree in order");
        binaryTree.traverseInOrder(root);
        System.out.println();
        System.out.println("-------------------------------------------");

        System.out.println("Going to delete 1st case - leaf case - no child");
        binaryTree.deleteNodeHasNoChild(root, 7);
        System.out.println("Traversing tree reverse order");
        binaryTree.traverseInOrder(root);
        System.out.println();
        System.out.println("-------------------------------------------");

        System.out.println("Going to delete 2nd case - one child");
        binaryTree.deleteNodeHasOneChild(root, 4);
        System.out.println("Traversing tree reverse order");
        binaryTree.traverseInOrder(root);
        System.out.println();
        System.out.println("-------------------------------------------");

//        System.out.println("Going to delete 3rd case - two children");
//        binaryTree.deleteNodeWithTwoChildren(root, 8);
//        System.out.println("Traversing tree reverse order");
//        binaryTree.traverseInOrder(root);
//        System.out.println();
//        System.out.println("-------------------------------------------");
    }
}
