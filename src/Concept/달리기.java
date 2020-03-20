package Concept;

import java.util.Scanner;

public class 달리기 {
    static int T;
    static int N;
    static int M;
    static int cnt;
    static int[] needs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int f;
            int s;
            sb.append("#"+t+" ");
            N = sc.nextInt();
            M = sc.nextInt();
            needs = new int[N];
            for(int i = 0; i < M; i++) {
                f = sc.nextInt()-1;
                s = sc.nextInt()-1;
                needs[f] |= 1<<s;
            }
            cnt = 0;
            dfs(0);
            sb.append(cnt+"\n");
            System.out.println(sb);
        }
    }
    static void dfs(int flag) {
        if(flag == M) {
            cnt++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if((flag & 1<<i) == 0) {
                if((flag & needs[i]) == needs[i]) {
                    dfs(flag | 1<<i);
                }
            }
        }
    }
}
