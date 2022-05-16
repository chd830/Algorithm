package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/6118
public class 숨바꼭질 {
    static int N;
    static int M;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }
        int[] cnt = new int[N+1];
        Arrays.fill(cnt, 987654321);
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        cnt[1] = 0;
        while(!que.isEmpty()) {
            int n = que.poll();
            for(int i : list[n]) {
                if(cnt[i] > cnt[n]+1) {
                    cnt[i] = cnt[n]+1;
                    que.add(i);
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= N; i++) {
            if(cnt[i] != 987654321)
                max = Math.max(max, cnt[i]);
        }
        int idx = -1;
        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(cnt[i] == max) {
                if(idx == -1)
                    idx = i;
                count++;
            }
        }
        System.out.println(idx+" "+cnt[idx]+" "+count);
    }
}
