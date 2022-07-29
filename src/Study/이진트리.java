package Study;

public class 이진트리 {
    static class Node {
        int root;
        Node l;
        Node r;
        Node(int root) {
            this.root = root;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "root=" + root +
                    ", l=" + l +
                    ", r=" + r +
                    '}';
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n1.l = n2;
        n1.r = n3;
        n2.l = n4;
        n2.r = n5;
        n3.l = n6;
        n3.r = n7;
        n4.r = n8;
        preorder(n1);
        System.out.println();
        inorder(n1);
        System.out.println();
        postorder(n1);
        System.out.println();
    }
    // 전위순회
    static void preorder(Node n) {
        System.out.print(n.root+"\t");
        if(n.l != null)
            preorder(n.l);
        if(n.r != null)
            preorder(n.r);
    }
    // 중위순회
    static void inorder(Node n) {
        if(n.l != null)
            inorder(n.l);
        System.out.print(n.root+"\t");
        if(n.r != null)
            inorder(n.r);
    }
    // 후위순회
    static void postorder(Node n) {
        if(n.l != null)
            postorder(n.l);
        if(n.r != null)
            postorder(n.r);
        System.out.print(n.root+"\t");
    }
}