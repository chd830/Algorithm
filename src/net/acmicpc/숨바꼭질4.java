package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질4 {

    static final int MAX = 1000000;
    static int[] from;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        map = new int[MAX];
        from = new int[MAX];
        map[N] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        while(!que.isEmpty()) {
            int now = que.poll();
            if(now+1 < MAX && map[now+1] == 0) {
                que.add(now+1);
                map[now+1] = map[now]+1;
                from[now+1] = now;
            }
            if(now-1 >= 0 && map[now-1] == 0) {
                que.add(now-1);
                map[now-1] = map[now]+1;
                from[now-1] = now;
            }
            if(now*2 < MAX && map[now*2] == 0) {
                que.add(now*2);
                map[now*2] = map[now] + 1;
                from[now*2] = now;
            }
        }
        System.out.println(map[K]);
        print(N, K);
        System.out.println();
    }

    public static void print(int n, int m) {
        if(n != m) {
            print(n, from[m]);
        }
        System.out.print(m+" ");
    }
}
