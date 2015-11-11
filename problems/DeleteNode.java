class DeleteNode {

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
        print(n1);
        deleteNode(n3);
        print(n1);
        System.out.println("OK");
    }

    public static void deleteNode(Node n) {
        n.data = n.next.data;
        n.next = n.next.next;
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
