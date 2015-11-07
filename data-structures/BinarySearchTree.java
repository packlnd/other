public class BinarySearchTree<T extends Comparable<T>> {
    private static class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        private Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;
    private int size;

    public BinarySearchTree() {
    }

    public BinarySearchTree(T[] V) {
        root = insert(V, 0, V.length);
    }

    private Node<T> insert(T[] V, int low, int high) {
        if (low >= high)
            return null;
        int mid = low+(high-low)/2;
        Node<T> n = new Node<T>(V[mid]);
        ++size;
        n.left = insert(V, low, mid);
        n.right = insert(V, mid+1, high);
        return n;
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

    public void flip() {
        flip(root);
    }

    private void flip(Node<T> node) {
        if (node == null)
            return;
        flip(node.left);
        flip(node.right);
        Node<T> tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

    public void insert(T data) {
        if (root == null) {
            ++size;
            root = new Node<T>(data);
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
                node.left = new Node<T>(data);
                ++size;
                return;
            }
            insert(data, node.left);
        } else {
            if (node.right == null) {
                node.right = new Node<T>(data);
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
        toString(sb, node.right);
        sb.append(")");
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node<T> node, T value) {
        if (node == null)
            return false;
        if (node.data == value)
            return true;
        if (contains(node.left, value))
            return true;
        if (contains(node.right, value))
            return true;
        return false;
    }

    public T getMax() {
        if (root == null)
            return null;
        Node<T> n;
        for (n = root; n.right != null; n=n.right);
        return n.data;
    }

    public T getMin() {
        if (root == null)
            return null;
        Node<T> n;
        for (n = root; n.left != null; n=n.left);
        return n.data;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(6);
        /*   5
         *  / \
         * 2   8
         *    /
         *   6
         */
        assert bst.size() == 4;
        assert bst.toString().equals("(5(2)(8(6)))");
        assert bst.depth() == 3;
        assert bst.leaves() == 2;
        assert bst.contains(5);
        assert !bst.contains(3);
        assert bst.getMax() == 8;
        assert bst.getMin() == 2;
        bst.flip();
        assert bst.size() == 4;
        assert bst.toString().equals("(5(8(6))(2))");
        assert bst.depth() == 3;
        assert bst.leaves() == 2;
        assert bst.contains(5);
        assert !bst.contains(3);
        BinarySearchTree<Integer> bst2 =
            new BinarySearchTree<Integer>(new Integer[]{1,2,3,4,5,6,7});
        assert bst2.toString().equals("(4(2(1)(3))(6(5)(7)))");
        assert bst2.depth() == 3;
        assert bst2.leaves() == 4;
        assert bst2.size() == 7;
        assert bst2.getMax() == 7;
        assert bst2.getMin() == 1;
        System.out.println("OK");
    }
}
