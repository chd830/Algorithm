package com.swexpertacademy;

import java.util.Scanner;

//중위순회
public class d4_1231 {
    static int[][] node;
    static com.swexpertacademy.Tree tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int t = 1; t <= 10; t++) {
            int N = sc.nextInt();
            node = new int[N/2+1][2];
            tree = new Tree(N);
            for(int i = 1, idx = 0; i <= N; i++) {
                int num = sc.nextInt();
                boolean flag = false;
                char alph = sc.next().charAt(0);
                for(int j = 0; j <= idx; j++) {
                    if(num == node[idx][0]) {
                        tree.setLeft(alph, node[idx][0]/2);
                        flag = true;
                    }
                    else if(num == node[idx][1]) {
                        tree.setRight(alph, node[idx][1]/2);
                        flag = true;
                    }
                }
                if(!flag) {
                    tree.set(alph, num);
                }
                if(i <= N/2) {
                    node[idx][0] = sc.nextInt();
                    if(node[idx][0] == N) {
                        continue;
                    }
                    node[idx][1] = sc.nextInt();
                    idx++;
                }
            }
            System.out.print("#"+t+" ");
            tree.inorder(1);
            System.out.println();
        }
    }
}
