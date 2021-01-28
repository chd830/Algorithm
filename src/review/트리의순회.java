package review;

import java.util.*;
import java.io.*;

// 분할정복
public class 트리의순회 {
    static int N;
    static int[] pos = new int[100000];
    // 중위
    static int[] inorder = new int[100000];
    // 후위
    static int[] postorder = new int[100000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(token.nextToken());
            // 중위순회에서 각각의 노드의 위치 저장
            pos[inorder[i]] = i;
        }
        for(int i = 1; i <= N; i++) {
            System.out.print(pos[i]+" ");
        }
        System.out.println();
        solve(0, N-1, 0, N-1);
    }
    static void solve(int is, int ie, int ps, int pe) {
        if(is>ie || ps>pe) return ;
        // 루트의 값 출력
        int root = postorder[pe];
        System.out.print(root+" ");
        int inRoot = pos[root]; // 해당되는 값이 있는 위치
        int left = inRoot-is; // 해당값의 위치에 중위순회가 시작하는 값을 빼면 왼쪽에 있는 노드들의 수가 된다.
        // 왼쪽 자식 노드들 찾기
        // 후위순회의 마지막 값은 루트라는 개념을 통해서 왼쪽 트리에서 계속 루트값을 찾아간다.
        solve(is, inRoot-1, ps, ps+left-1);
        // 오른쪽 자식 노드들 찾기
        //
        solve(inRoot+1, ie, ps+left, pe-1);
    }

//11
//6 4 7 2 8 5 9 1 10 3 11
//6 7 4 8 9 5 2 10 11 3 1


//    static void solve(int is, int ie, int ps, int pe) {
//        if(is > ie || ps > pe) {
//            return;
//        }
//        int root = postorder[pe];
//        System.out.println(root+" ");
//        int inRoot = preorder[root];
//        int left = inRoot-is;
//        solve(is, inRoot-1, ps, ps+left-1);
//        solve(inRoot+1, ie, ps+left, pe-1);
//    }
}
