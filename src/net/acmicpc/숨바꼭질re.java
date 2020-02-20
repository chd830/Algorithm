package net.acmicpc;

import java.util.*;

public class 숨바꼭질re {
    static int N;
    static int K;
    static int[] time;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        time = new int[100001];
//        System.out.println(Arrays.toString(time));
        find(N, K);
        System.out.println(time[K]);
    }
    public static void find(int N, int K) {
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        while (!que.isEmpty()) {
            N = que.poll();
            if(N == K) {
                return;
            }
            if (N + 1 <= 100000 && time[N + 1] == 0) {
                time[N + 1] = time[N] + 1;
                que.add(N+1);
//                System.out.println(Arrays.toString(time));
            }
            if (N - 1 <= 100000 && time[N - 1] == 0) {
                time[N - 1] = time[N] + 1;
                que.add(N-1);
//                System.out.println(Arrays.toString(time));
            }
            if (N * 2 <= 100000 && time[N * 2] == 0) {
                time[N * 2] = time[N] + 1;
                que.add(N*2);
//                System.out.println(Arrays.toString(time));
            }
        }
    }
}
