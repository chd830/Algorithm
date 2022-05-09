package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1991
public class 트리순회 {
    static class Tree {
        String root;
        String left;
        String right;
        Tree(String root, String left, String right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }
    static Tree[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        trees = new Tree[N];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            trees[i] = new Tree(token.nextToken(), token.nextToken(), token.nextToken());
        }
        preorder("A");
        System.out.println();
        inorder("A");
        System.out.println();
        postorder("A");
    }
    static void preorder(String root) {
        if(root.equals("."))
            return;
        for(int i = 0; i < trees.length; i++) {
            if(trees[i].root.equals(root)) {
                System.out.print(root);
                preorder(trees[i].left);
                preorder(trees[i].right);
            }
        }
    }
    static void inorder(String root) {
        if(root.equals("."))
            return;
        for(int i = 0; i < trees.length; i++) {
            if(trees[i].root.equals(root)) {
                inorder(trees[i].left);
                System.out.print(root);
                inorder(trees[i].right);
            }
        }
    }
    static void postorder(String root) {
        if(root.equals("."))
            return;
        for(int i = 0; i < trees.length; i++) {
            if(trees[i].root.equals(root)) {
                postorder(trees[i].left);
                postorder(trees[i].right);
                System.out.print(root);
            }
        }
    }
}
