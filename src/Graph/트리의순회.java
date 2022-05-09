package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2263
public class 트리의순회 {
    static int N;
    static int[] inorder;
    static int[] postorder;
    static int[] inorder_idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inorder = new int[N+1];
        postorder = new int[N+1];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            inorder[i] = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            postorder[i] = Integer.parseInt(token.nextToken());
        inorder_idx = new int[N+1];
        for(int i = 0; i < N; i++)
            inorder_idx[inorder[i]] = i;
        set(0, N-1, 0, N-1);
    }
    static void set(int start, int end, int postStart, int postEnd) {
        if(start > end || postStart > postEnd)
            return;
        int root = postorder[postEnd];
        System.out.print(root+" ");
        int rootIdx = inorder_idx[root];
        int left = rootIdx-start;
        // left
        set(start, rootIdx-1, postStart, postStart+left-1);
        // right
        set(rootIdx+1, end, postStart+left, postEnd-1);
    }
}