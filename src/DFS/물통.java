package DFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2251
public class 물통 {
    static int[] to = {0, 0, 1, 1, 2, 2};
    static int[] from = {1, 2, 0, 2, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] water = new int[3];
        water[0] = Integer.parseInt(token.nextToken());
        water[1] = Integer.parseInt(token.nextToken());
        water[2] = Integer.parseInt(token.nextToken());
        int sum = water[2];
        boolean[][] check = new boolean[201][201];
        boolean[] ans = new boolean[201];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        que.add(0);
        check[0][0] = true;
        ans[water[2]] = true;
        while(!que.isEmpty()) {
            int[] cur = new int[3];
            cur[0] = que.poll();
            cur[1] = que.poll();
            cur[2] = sum-cur[0]-cur[1];
            // from에서 to로 이동하기
            for(int k = 0; k < 6; k++) {
                int[] next = {cur[0], cur[1], cur[2]};
                // to로 이동한 물의 값
                next[to[k]] += next[from[k]];
                next[from[k]] = 0;
                // 물통보다 큰 값일 때 최댓값만 담을 수 있게 조정하기
                if(next[to[k]] >= water[to[k]]) {
                    next[from[k]] = next[to[k]]-water[to[k]];
                    next[to[k]] = water[to[k]];
                }
                // 옮길 수 있게 조정한 물 양동이가 방문하지 않은 지점일 때 
                if(!check[next[0]][next[1]]) {
                    check[next[0]][next[1]] = true;
                    que.add(next[0]);
                    que.add(next[1]);
                    // 첫번째 물통이 비어있을 때 세번째 물통의 물의 양 체크
                    if(next[0] == 0) {
                        ans[next[2]] = true;
                    }
                }
            }
        }
        for(int i = 0; i <= water[2]; i++) {
            if(ans[i])
                System.out.print(i+" ");
        }
        System.out.println();
    }
}