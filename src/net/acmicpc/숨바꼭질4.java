package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 숨바꼭질4 {

    public static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dist = new int[MAX];
        int[] from = new int[MAX];
        dist[n] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(n);
        while (!que.isEmpty()) {
            int now = que.remove();
            if (now - 1 >= 0 && dist[now - 1] == 0) {
                que.add(now - 1);
                dist[now - 1] = dist[now] + 1;
                from[now - 1] = now;
            }
            if (now + 1 < MAX && dist[now + 1] == 0) {
                que.add(now + 1);
                dist[now + 1] = dist[now] + 1;
                from[now + 1] = now;
            }
            if (now * 2 < MAX && dist[now * 2] == 0) {
                que.add(now * 2);
                dist[now * 2] = dist[now] + 1;
                from[now * 2] = now;
            }
        }
        System.out.println(dist[m]);
        Stack<Integer> ans = new Stack<>();
        for (int i = m; i != n; i = from[i]) {
            ans.push(i);
        }
        ans.push(n);
        while (!ans.isEmpty()) {
            System.out.print(ans.pop() + " ");
        }
        System.out.println();
    }
}
