package com.swexpertacademy;

public class Tree {
    char[] tree;
    String str="";
    public Tree(int n) {
        tree = new char[n+1];

    }
    public void set(char data, int node) {
        tree[node] = data;
    }
    public void setLeft(char data, int parent) {
        tree[parent*2] = data;
    }
    public void setRight(char data, int parent) {
        tree[parent*2+1] = data;
    }
    public void inorder(int node) {
        if(node < tree.length && tree[node] != '\0') {
            inorder(node*2);
            System.out.print(tree[node]);
            inorder(node*2+1);
        }
    }
    public void backorder(int node) {
        boolean left = false;
        boolean right = false;
        if(node * 2 < tree.length && tree[node*2] != '\0') {
            left = true;
            backorder(node*2);
        }
        if(node*2+1 < tree.length && tree[node*2+1] != '\0') {
            right = true;
            backorder(node*2+1);
        }
        if(Character.isDigit(tree[node])) {
            //양쪽 다 자식이 없어야됨
            if (node * 2 + 1 < tree.length) {
                if (tree[node * 2] != '\0' || tree[node * 2 + 1] != '\0') {
                    left = false;
                }
            }
        }
        else {
            //양쪽 다 자식이 있어야 됨
            if(node*2+1 < tree.length) {
                if(tree[node*2] == '\0' || tree[node*2+1] == '\0') {
                    right = false;
                }
            }
        }
        System.out.print(tree[node]);
    }
}
