package review;

import java.util.*;
import java.io.*;

// 트리의 순회
public class acmicpc2263 {
    static int N;
    static int[] preorder;
    static int[] inorder;
    static int[] postorder;
    static int[] idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inorder = new int[N];
        postorder = new int[N];
        preorder = new int[N];
        idx = new int[N];
        StringTokenizer token = null;
        token = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++) {
            inorder[j] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++) {
            postorder[j] = Integer.parseInt(token.nextToken());
        }
        for(int i = 0; i < N; i++) {
            idx[inorder[i]] = i;
        }
        setPreorder(0, N-1, 0, N-1);
    }
    static void setPreorder(int leftB, int leftE, int rightB, int rightE) {
        System.out.println(leftB+"\t"+leftE+"\t"+rightB+"\t"+rightE);
        if(leftB > leftE || rightB > rightE) {
            return;
        }
        int root = postorder[rightE];
        System.out.print(root+" ");
        // 왼
        setPreorder(leftB, idx[root]-1, rightB, (idx[root]-leftB-1));
        // 오른
        setPreorder(idx[root]+1, leftE, rightB+(idx[root]-leftB), rightE-1);
    }
}
