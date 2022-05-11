package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1005
public class ACMCraft {
    // 위상정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int K = Integer.parseInt(token.nextToken());
            int[] time = new int[N+1];
            token = new StringTokenizer(br.readLine());
            List<Integer>[] list = new ArrayList[N+1];
            for(int i = 0; i <= N; i++)
                list[i] = new ArrayList<>();
            for(int k = 1; k <= N; k++)
                time[k] = Integer.parseInt(token.nextToken());
            int[] cnt = new int[N+1];
            for(int k = 0; k < K; k++) {
                token = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(token.nextToken());
                int to = Integer.parseInt(token.nextToken());
                list[from].add(to);
                cnt[to]++;
            }
            Queue<Integer> que = new LinkedList<>();
            int[] result = new int[N+1];
            for(int i = 1; i <= N; i++) {
                if(cnt[i] == 0) {
                    que.add(i);
                    result[i] = time[i];
                }
            }
            int start = Integer.parseInt(br.readLine());

            while(!que.isEmpty()) {
                int n = que.poll();
                for (int l : list[n]) {
                    result[l] = Math.max(result[l], result[n] + time[l]);
                    --cnt[l];
                    if (cnt[l] == 0)
                        que.add(l);
                }
            }
            System.out.println(result[start]);
        }
    }
}
