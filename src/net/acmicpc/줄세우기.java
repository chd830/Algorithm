package net.acmicpc;

import java.util.*;

public class 줄세우기 {
    static int N;
    static int M;
    static int[] cnt;
    static List<Integer>[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        cnt = new int[N];
        list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList();
        }
        for(int i = 0; i < M; i++) {
            int num1 = sc.nextInt()-1;
            int num2 = sc.nextInt()-1;
            list[num1].add(num2);
            cnt[num2]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(cnt[i] == 0) {
                que.add(i);
            }
        }
        while(!que.isEmpty()) {
            int n = que.poll();
            sb.append(n+1).append(" ");
            for(Integer i : list[n]) {
                if(--cnt[i] == 0) {
                    que.add(i);
                }
            }
        }
        System.out.println(sb);
    }
}
