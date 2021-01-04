package review;

import java.util.*;
import java.io.*;

public class 트리순회 {
    static class Node {
        char root;
        char left;
        char right;
        Node(char root, char left, char right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return root+", "+left+", "+right;
        }
    }
    static int N;
    static List<Node> list;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        sb = new StringBuilder();
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            Node n = new Node(token.nextToken().charAt(0), token.nextToken().charAt(0), token.nextToken().charAt(0));
            list.add(n);
        }
//        전위순회
        preorder('A');
        sb.append("\n");
//        중위순회
        inorder('A');
        sb.append("\n");
//        후위순회
        postorder('A');
        sb.append("\n");
        System.out.println(sb);
    }
    static void preorder(char n) {
        if(n == '.')
            return;
        sb.append(n);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).root == n) {
                preorder(list.get(i).left);
                preorder(list.get(i).right);
            }
        }
    }
    static void inorder(char n) {
        if(n == '.')
            return;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).root == n) {
                inorder(list.get(i).left);
                sb.append(n);
                inorder(list.get(i).right);
            }
        }
    }
    static void postorder(char n) {
        if(n == '.')
            return;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).root == n) {
                postorder(list.get(i).left);
                postorder(list.get(i).right);
                sb.append(n);
            }
        }
    }
}
