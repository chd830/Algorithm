package review;

import java.util.*;
import java.io.*;

public class 이진트리 {
    static class Node {
        int val;
        Node(int val) {
            this.val = val;
        }
        Node left;
        Node right;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node cur = new Node(Integer.parseInt(br.readLine()));
        String str = null;
        while((str = br.readLine()) != null && str.length() != 0) {
            Node n = new Node(Integer.parseInt(str));
            put(cur, n);
        }
        postOrder(cur);
    }
    static void postOrder(Node n) {
        if(n == null) {
            return;
        }
        postOrder(n.left);
        postOrder(n.right);
        System.out.println(n.val);
    }
    static void put(Node cur, Node n) {
        if(cur.val > n.val) {
            if(cur.left != null) {
                put(cur.left, n);
            }
            else {
                cur.left = n;
            }
        }
        else {
            if(cur.right != null) {
                put(cur.right, n);
            }
            else {
                cur.right = n;
            }
        }
    }
}
