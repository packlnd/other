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

    public void insert(T data) {
        if (root == null) {
            root = new Node<T>(data, null, null);
            return;
        }
        insert(data, root);
    }

    private void insert(T data, Node<T> node) {
        if (node == null) {
            node = new Node<T>(data, null, null);
            return;
        }
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
    }
}
