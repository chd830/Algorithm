package Concept;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Object[] nodes;
    private int lastIndex;
    private final int SIZE;

    public BinaryTree(int size) {
        nodes = new Object[size + 1];
        SIZE = size;
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean isFull() {
        return lastIndex == SIZE;
    }

    public void add(Object e) {
        if (isFull()) {
            System.out.println("포화");
            return;
        }
        nodes[++lastIndex] = e;
    }

    public void searchPreOrder(int idx) { //VLR
        if(idx >= SIZE) {
            return;
        }
        System.out.print(nodes[idx] + " ");//V
        searchPreOrder(idx * 2);//L
        searchPreOrder(idx * 2 + 1);//R
    }

    public void searchInOrder(int idx) {//LVR
        if(idx >= SIZE) {
            return;
        }
        searchInOrder(idx * 2);//L
        System.out.print(nodes[idx] + " ");//V
        searchInOrder(idx * 2 + 1);//R
    }
    public void searPostOrder(int idx) {//LRV
        if(idx >= SIZE) {
            return;
        }
        searPostOrder(idx * 2);//L
        searPostOrder(idx * 2 + 1);//R
        System.out.print(nodes[idx] + " ");//V
    }

    public void searchBFS() {
        if(isEmpty()) return;
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);//루트노드
        while(!que.isEmpty()) {
            int size = que.size();
            while(size-- > 0) {
                int cur = que.poll();
                System.out.print(nodes[cur]+" ");
                if(cur*2 <= lastIndex) {
                    que.offer(cur*2);//왼쪽자식
                }
                if(cur*2+1 <= lastIndex) {
                    que.offer(cur*2+1);//오른쪽자식
                }
            }
            System.out.println();
        }
    }
}
