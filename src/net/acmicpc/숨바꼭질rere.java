package net.acmicpc;

import java.util.*;

public class 숨바꼭질rere {
    static final int MAX = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[] check = new boolean[MAX+1];
        int[] dist = new int[MAX+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        while(!que.isEmpty()) {
            int num = que.poll();
            if(num-1 >= 0 && !check[num-1]) {
                    que.add(num-1);
                    check[num-1] = true;
                    dist[num-1] = dist[num] + 1;
            }
            if(num+1 <= MAX && !check[num+1]) {
                que.add(num+1);
                check[num+1] = false;
                dist[num+1] = dist[num] + 1;
            }
            if(num*2 < MAX && !check[num*2]) {
                que.add(num*2);
                check[num*2] = false;
                dist[num*2] = dist[num] + 1;
            }
        }
    }
}
