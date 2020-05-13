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
    //방문한 노드에서 싸이클이 끝났는지 확인(더이상 방문할 필요가 없는 것을 체크)
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
        //방문한 지점일 때 끝냄
        if(visited[now]) {
            return;
        }
        //방문처리를 하고
        visited[now] = true;
        //다음에 방문할 싸이클을 next에 저장
        int next = arr[now];
        //다음 싸이클을 방문하지 않았으면 다음 호출로 넘어간다.
        if(!visited[next]) {
            dfs(next);
        }
        else {
            //다음 싸이클이 방문한 싸이클일때
            //끝이 나지않은 싸이클이라면
            if(!finished[next]) {
                //연속되는 싸이클을 찾아서 수를 카운트
                cnt++;
                for(int i = next; i != now; i = arr[i]) {
                    cnt++;
                }
            }
        }
        //방문한 싸이클로 처리한다.
        finished[now] = true;
    }
}
