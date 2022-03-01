package DFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16987
public class 계란으로계란치기 {
    static class Egg implements Comparable<Egg> {
        int val;
        int weight;
        boolean end;
        Egg(int val, int weight, boolean end) {
            this.val = val;
            this.weight = weight;
            this.end = end;
        }

        @Override
        public int compareTo(Egg o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        eggs = new Egg[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), false);
        }
        dfs(0, 0);
        System.out.println(max == Integer.MIN_VALUE ? 0 : max);
    }
    static int N;
    static int max;
    static Egg[] eggs;
    static void dfs(int idx, int cnt) {
        if(idx == N)
            return;
        if(eggs[idx].end) {
            dfs(idx+1, cnt);
            return;
        }
        for(int i = 0; i < N; i++) {
            int tmp = 0;
            if(idx == i || eggs[i].end)
                continue;
            eggs[idx].val -= eggs[i].weight;
            eggs[i].val -= eggs[idx].weight;

            if(eggs[idx].val <= 0) {
                eggs[idx].end = true;
                tmp++;
            }
            if(eggs[i].val <= 0) {
                eggs[i].end = true;
                tmp++;
            }
            max = Math.max(max, cnt+tmp);

            dfs(idx+1, cnt+tmp);

            if(eggs[idx].val <= 0)
                eggs[idx].end = false;
            if(eggs[i].val <= 0)
                eggs[i].end = false;
            eggs[idx].val += eggs[i].weight;
            eggs[i].val += eggs[idx].weight;
        }
    }
}
