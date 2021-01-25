package review;

import java.util.*;
import java.io.*;

public class 스타트와링크 {
    static int N;
    static int min;
    static int[][] maps;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        maps = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(min);
    }
    static void comb(int idx, int subIdx) {
        if(subIdx == N/2) {
            int sum1 = 0;
            int sum2 = 0;
            // 조합으로 접근해서 방문한 지점과 방문하지 않은 지점의 합 구하기
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    if(visited[i] != visited[j]) continue;
                    if(!visited[i]) {
                        sum2 += maps[i][j] + maps[j][i];
                    }
                    else {
                        sum1 += maps[i][j] + maps[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(sum1-sum2));
            return;
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(i+1, subIdx+1);
                visited[i] = false;
            }
        }
    }
}
