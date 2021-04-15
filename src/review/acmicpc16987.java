package review;

import java.util.*;
import java.io.*;

// 계란으로 계란치기
public class acmicpc16987 {
    static class Egg implements Comparable<Egg> {
        int dur;
        int weight;
        boolean isBreak;
        Egg(int dur, int weight, boolean isBreak) {
            this.dur = dur;
            this.weight = weight;
            this.isBreak = isBreak;
        }

        @Override
        public String toString() {
            return "Egg{" +
                    "dur=" + dur +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Egg o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        max = Integer.MIN_VALUE;
        boolean[] check = new boolean[N];
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
           eggs[i] = new Egg(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), false);
        }
        cnt = 0;
        dfs(0, 0);
        System.out.println(max == Integer.MIN_VALUE ? 0 : max);
    }
    static int N;
    static int cnt;
    static int max;
    static Egg[] eggs;
    static void dfs(int idx, int cnt) {
        if(idx == N)
            return;
        if(eggs[idx].isBreak) {
            dfs(idx + 1, cnt);
            return;
        }
        for(int i = 0; i < N; i++) {
            int tmp = 0;
            if(idx == i || eggs[i].isBreak)
                continue;
            eggs[idx].dur -= eggs[i].weight;
            eggs[i].dur -= eggs[idx].weight;

            if(eggs[idx].dur <= 0) {
                eggs[idx].isBreak = true;
                tmp++;
            }
            if(eggs[i].dur <= 0) {
                eggs[i].isBreak = true;
                tmp++;
            }
            max = Math.max(max, cnt+tmp);

            dfs(idx+1, cnt+tmp);

            if(eggs[idx].dur <= 0)
                eggs[idx].isBreak = false;
            if(eggs[i].dur <= 0)
                eggs[i].isBreak = false;
            eggs[idx].dur += eggs[i].weight;
            eggs[i].dur += eggs[idx].weight;
        }
    }
}
