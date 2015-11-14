class Merge {
    static class Node {
        int data;
        Node next;

        Node() {
        }

        Node(int data) {
            this.data=data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n2.next = n3;
        n1.next = n2;

        Node n4 = new Node(2);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n5.next = n6;
        n4.next = n5;

        print(n1);
        print(n4);

        n1 = merge(n1, n4);
        print(n1);
    }

    public static Node merge(Node n1, Node n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        Node head;
        if (n1.data < n2.data) {
            head = n1;
        } else {
            head = n2;
            n2 = n1;
            n1 = head;
        }
        while (n1.next != null && n2.next != null) {
            if (n1.next.data > n2.data) {
                Node tmp = n1.next;
                n1.next = n2;
                n2 = tmp;
            }
            n1 = n1.next;
        }
        if (n1.next == null) n1.next = n2;
        return head;
    }

    public static void print(Node n) {
        Node tmp = n;
        while (tmp != null) {
            if (tmp != n)
                System.out.print("<-");
            System.out.print(tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }
}
