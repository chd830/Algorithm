package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1389
public class 케빈베이컨6단계법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N+1][N+1];
        List<Integer>[] list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                boolean[] visited = new boolean[N+1];
                visited[i] = true;
                Queue<Integer> que = new LinkedList<>();
                que.add(i);
                while(!que.isEmpty()) {
                    int n = que.poll();
                    for(int l : list[n]) {
                        if(!visited[l]) {
                            visited[l] = true;
                            arr[i][l] = arr[i][n]+1;
                            que.add(l);
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int num = 0;
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += arr[i][j];
            }
            if(min > sum) {
                min = sum;
                num = i;
            }
        }
        System.out.println(num);
    }
}
