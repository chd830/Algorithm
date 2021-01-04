package review;

import java.util.*;
import java.io.*;

public class 트리의부모찾기11725 {
    static int N;
    static int[] parents;
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
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
        dfs(1);
        for(int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }
    static void dfs(int idx) {
        visited[idx] = true;
        for(int i : list[idx]) {
            if(!visited[i]) {
                parents[i] = idx;
                dfs(i);
            }
        }
    }
}
