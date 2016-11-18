public class BinarySearchTree {

  private class Node {
    private Node left;
    private Node right;
    private int data;
    private Node(int data) {
      this.data = data;
    }
  }

  private Node root;

  public BinarySearchTree() {
  }

  public BinarySearchTree(BinarySearchTree other) {
  }

  public BinarySearchTree(int[] V) {
    root = createBinarySearchTreeFromArray(V, 0, V.length);
  }

  private Node createBinarySearchTreeFromArray(int[] V, int lo, int hi) {
    if (lo == hi)
      return null;
    int mid = lo + (hi-lo)/2;
    Node node = new Node(V[mid]);
    node.left = createBinarySearchTreeFromArray(V, lo, mid);
    node.right = createBinarySearchTreeFromArray(V, mid+1, hi);
  }

  public int depth() {
  }

  public boolean isBinarySearchTree() {
  }

  public int heightOfValue(int value) {
  }

  public void insert(int value) {

  }

  public boolean contains(int value) {
    if (root==null) {
      return false;
    }
    Node current = root;
    while (current != null) {
      if (current.data == value) {
        return true;
      } else if (current.data > value) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
    return true;
  }

  public void flip() {
  }
}
