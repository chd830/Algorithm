package review;

import java.util.*;
import java.io.*;

public class 트리의부모찾기 {
    static int N;
    static int[] parents;
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        parents = new int[N+1];

        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            token = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(token.nextToken());
            int num2 = Integer.parseInt(token.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }

        //루트노드부터 시작하기
        dfs(1);
        for(int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }
    static void dfs(int idx) {
        visited[idx] = true;
        // 노드와 연결된 노드들을 가져오고 방문한 적이 없으면 지금 노드가 부모노드가 된다.
        for(int i : list[idx]) {
            if(!visited[i]) {
                parents[i] = idx;
                dfs(i);
            }
        }
    }
}
