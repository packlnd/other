import java.util.HashSet;

public class RemoveDuplicate {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        public Node first;
        public int size;

        public LinkedList() {
            first = null;
            size = 0;
        }

        public void add(int data) {
            Node n = new Node(data);
            if (first == null) {
                first = n;
                ++size;
                return;
            }
            n.next = first;
            first = n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Node tmp = first;
            while (tmp != null) {
                if (tmp != first)
                    sb.append(", ");
                sb.append(tmp.data);
                tmp = tmp.next;
            }
            return sb.append("]").toString();
        }

        public void removeDuplicates() {
            HashSet<Integer> set = new HashSet<Integer>();
            if (first == null) return;
            set.add(first.data);
            for (Node tmp = first; tmp.next != null; tmp = tmp.next) {
                System.out.println("Data is: " + tmp.next.data);
                if (set.contains(tmp.next.data))
                    tmp.next = tmp.next.next;
                tmp = tmp.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        assert ll.toString().equals("[]");
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(1);
        assert ll.toString().equals("[1, 3, 2, 1]");
        ll.removeDuplicates();
        assert ll.toString().equals("[1, 3, 2]");
        System.out.println("OK");
    }
}
