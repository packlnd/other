import java.util.List;
import java.util.ArrayList;

public class HashSet<T> {

  private class Node {
    T data;
    Node next;

    public Node(T data) {
      this.data = data;
    }
  }

  private int capacity;
  private int size;
  private List<Node> nodes;

  public HashSet() {
    capacity = 16;
    size = 0;
    nodes = new ArrayList<Node>(capacity);
  }

  private int index(T element) {
    return Math.abs((element.hashCode()) % capacity);
  }

  public void add(T element) {
    if (shouldDoubleCapacity())
      doubleCapacity();
    // TODO
  }

  public boolean contains(T element) {
    // TODO
    return false;
  }

  private void doubleCapacity() {
    // TODO
  }

  private boolean shouldDoubleCapacity() {
    // TODO
    return false;
  }
}
