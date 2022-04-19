package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/18352
public class 특정거리의도시찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken());
        List<Integer>[] list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            list[n1].add(n2);
        }
        int[] arr = new int[N+1];
        Arrays.fill(arr, -1);
        Queue<Integer> que = new LinkedList<>();
        que.add(X);
        arr[X] = 0;
        while(!que.isEmpty()) {
            int n = que.poll();
            for(int i : list[n]) {
                if(arr[i] == -1) {
                    arr[i] = arr[n]+1;
                    que.add(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(arr[i] == K)
                sb.append(i).append("\n");
        }
        System.out.println(sb.length() == 0 ? -1 : sb.toString());
    }
}
