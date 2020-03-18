package Concept;

public class SimpleLinkedList {
    private Node head;
    class Node {
        Object data;
        Node link;

        Node(Object data, Node link) {
            this.data = data;
            this.link = link;
        }
    }

    public void addFirstNode(Object data) {
        head = new Node(data, head);
    }

    public Node getNode(Object data) {
        Node curNode = head;
        while (curNode != null) {
            if (curNode.data == data) {
                return curNode;
            }
            curNode = curNode.link;
        }
        return null;
    }

    public void printList() {
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.link;
        }
        System.out.println();
    }
}
class Main {
    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();
        list.addFirstNode("신은총");
        list.printList();
        list.addFirstNode("신운탁");
        list.printList();
        list.addFirstNode("최순진");
        list.printList();

        System.out.println(list.getNode("신은총"));
    }
}
