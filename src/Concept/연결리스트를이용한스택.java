package Concept;

public class 연결리스트를이용한스택 {
    class Node {
        Object data;
        Node link;
        Node(Object data, Node top) {
            this.data = data;
            this.link = top;
        }
    }
    private Node top;
    public void push(String data) {
        top = new Node(data, top);
    }
    public boolean isEmpty() {
        return top == null;
    }
    public Object pop() {
        if(isEmpty()) {
            System.out.println("스택이 비어있어 pop불가");
            return null;
        }
        Node popNode = top;
        top = popNode.link;
        popNode.link = null;
        return popNode.data;
    }
    public Object peek() {
        if(isEmpty()) {
            System.out.println("스택이 비어있으 pekk불가");
            return null;
        }
        return top.data;
    }
}
