package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트 {
    static int N;
    static int cnt;
    static int[] arr;
    //방문 여부 체크
    static boolean[] visited;
    //방문한 노드에서 싸이클이 끝났는지 확인
    static boolean[] finished;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            cnt = 0;
            arr = new int[N+1];
            visited = new boolean[N+1];
            finished = new boolean[N+1];
            token = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
            for(int i = 1; i <= N; i++) {
                dfs(i);
            }
            sb.append((N-cnt)+"\n");
        }
        System.out.println(sb);
    }

    static void dfs(int now) {
        if(visited[now]) {
            return;
        }
        visited[now] = true;
        int next = arr[now];
        if(!visited[next]) {
            dfs(next);
        }
        else {
            //다음 노드 기준으로 싸이클을 확인한다.
            if(!finished[next]) {
                cnt++;
                for(int i = next; i != now; i = arr[i]) {
                    cnt++;
                }
            }
        }
        finished[now] = true;
    }
}
