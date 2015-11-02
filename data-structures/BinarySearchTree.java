public class BinarySearchTree<T extends Comparable<T>> {
    private static class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        private Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node<T> root;
    private int size;

    public BinarySearchTree() {
    }

    public int depth() {
        return depth(root);
    }

    private int depth(Node<T> node) {
        if (node == null)
            return 0;
        return Math.max(depth(node.left), depth(node.right))+1;
    }

    public int leaves() {
        return leaves(root);
    }

    private int leaves(Node<T> node) {
        if (size <= 1) return size;
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return leaves(node.left) + leaves(node.right);
    }

    public void insert(T data) {
        if (root == null) {
            ++size;
            root = new Node<T>(data, null, null);
            return;
        }
        insert(data, root);
    }

    private void insert(T data, Node<T> node) {
        int compare = data.compareTo(node.data);
        if (compare == 0)
            return;
        if (compare < 0) {
            if (node.left == null) {
                node.left = new Node<T>(data, null, null);
                ++size;
                return;
            }
            insert(data, node.left);
        } else {
            if (node.right == null) {
                node.right = new Node<T>(data,null,null);
                ++size;
                return;
            }
            insert(data, node.right);
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, root);
        return sb.toString();
    }

    private void toString(StringBuilder sb, Node<T> node) {
        if (node == null)
            return;
        sb.append("(");
        sb.append(node.data);
        toString(sb, node.left);
        sb.append(",");
        toString(sb, node.right);
        sb.append(")");
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(6);
        System.out.println(bst.size());
        System.out.println(bst);
        System.out.println("Depth is: " + bst.depth());
        System.out.println("Number of leaves: " + bst.leaves());
    }
}
