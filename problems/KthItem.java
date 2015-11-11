class KthItem {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n5.next = n6;
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        assert kthElement(n1, 3) == 3;
        assert kthElement(n1, 0) == 6;
        assert kthElement(n1, 1) == 5;
        System.out.println("OK");
    }

    public static int kthElement(Node n, int k) {
        int size=0;
        for (Node tmp = n; tmp != null; tmp = tmp.next)
            ++size;

        Node tmp = n;
        for (int i=0; i<size-k; ++i)
            tmp=tmp.next;
        return tmp.data;
    }
}
