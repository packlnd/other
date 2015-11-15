class Partition {
    static class Node {
        int data;
        Node next;
        Node(int data) {this.data=data;}
    }

    public static void main(String[] args) {

        Node n1 = new Node(6);
        Node n2 = new Node(17);
        Node n3 = new Node(5);
        Node n4 = new Node(1);
        Node n5 = new Node(9);
        Node n6 = new Node(3);
        n5.next = n6;
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        print(n1);
        n1 = partition(n1, 5);
        print(n1);
    }

    public static Node partition(Node n, int x) {
        Node f1 = null;
        Node f2 = null;
        for (Node i=n; i!=null; i=i.next) {
            Node tmp = new Node(i.data);
            if (i.data <= x) {
                if (f1 == null) {
                    f1 = tmp;
                    continue;
                }
                tmp.next = f1.next;
                f1.next = tmp;
            } else {
                if (f2 == null) {
                    f2 = tmp;
                    continue;
                }
                tmp.next = f2.next;
                f2.next = tmp;
            }
        }
        Node tmp;
        for (tmp = f1; tmp.next != null; tmp=tmp.next);
        tmp.next = f2;
        return f1;
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
