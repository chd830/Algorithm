package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR {
    static final int MAX = 10001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] d = new int[MAX];
            int[] v = new int[MAX];
            boolean[] c = new boolean[MAX];
            char[] w = new char[MAX];
            Queue<Integer> que = new LinkedList<>();
            que.add(n);
            c[n] = true;
            d[n] = 0;
            v[n] = -1;
            while(!que.isEmpty()) {
                int now = que.poll();
                int next = (now*2)%10000;
                if(c[next] == false) {
                    que.add(next);
                    c[next] = true;
                    d[next] = d[now] + 1;
                    v[next] = now;
                    w[next] = 'D';
                }
                next = now - 1;
                if(next == -1) {
                    next = 9999;
                }
                if(c[next] == false) {
                    d[next] = d[now] + 1;
                    w[next] = 'S';
                    c[next] = true;
                    v[next] = now;
                    que.add(next);
                }
                next = (now%1000)*10 + now/1000;
                if(d[next] == 0) {
                    d[next] = now + 1;
                    c[next] = true;
                    w[next] = 'L';
                    v[next] = now;
                    que.add(next);
                }
                next = (now/10) + (now%10)*1000;
                if(d[next] == 0) {
                    d[next] = now + 1;
                    w[next] = 'R';
                    v[next] = now;
                    c[next] = true;
                    que.add(next);
                }
            }
            StringBuilder ans = new StringBuilder();
            while(m != n) {
                ans.append(w[m]);
                m = v[m];
            }
            System.out.println(ans.reverse().toString());
        }
    }
}
