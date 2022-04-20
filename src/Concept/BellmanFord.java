package Concept;

import java.util.*;

// https://developer-davii.tistory.com/89
public class BellmanFord {
    static class Node {
        int x;
        int val;
        Node(int x, int val) {
            this.x = x;
            this.val = val;
        }
    }
    public static void main(String[] args) {
        int[] d = new int[6];
        Arrays.fill(d, 1234567);
        List<Node>[] list = new ArrayList[6];
        for(int i = 0; i < list.length; i++)
            list[i] = new ArrayList<>();
        list[1].add(new Node(2, -4));
        list[1].add(new Node(3, 5));
        list[1].add(new Node(4, 2));
        list[1].add(new Node(5, 3));

        list[2].add(new Node(2, 0));
        list[2].add(new Node(4, -1));

        list[3].add(new Node(2, 0));
        list[3].add(new Node(5, 7));

        list[4].add(new Node(4, 0));
        list[4].add(new Node(5, -6));

        list[5].add(new Node(4, -4));
        list[5].add(new Node(5, 0));

        int start = 1;
        d[start] = 0;
        for(int v = 0; v < list.length; v++) {
            for(Node n : list[v]) {
                d[n.x] = Math.min(d[n.x], d[v]+n.val);
            }
        }
        System.out.println(Arrays.toString(d));
    }
}
