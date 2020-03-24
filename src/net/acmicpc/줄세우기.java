package net.acmicpc;

import java.util.*;

public class 줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] cnt = new int[N];
        List<Integer>[] list = new ArrayList[N];
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
