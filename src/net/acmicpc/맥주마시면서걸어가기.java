package net.acmicpc;

import java.util.*;

public class 맥주마시면서걸어가기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        loop: for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            Queue<int[]> que = new LinkedList<>();
            que.add(new int[] { sc.nextInt(), sc.nextInt() });
            int[][] pos = new int[N+1][2];
            boolean[] visited = new boolean[N+1];
            for(int i = 0; i < N+1; i++) {
                pos[i][0] = sc.nextInt();
                pos[i][1] = sc.nextInt();
            }
            while(!que.isEmpty()) {
                int[] node = que.poll();
                if(node[0] == pos[N][0] && node[1] == pos[N][1]) {
                    System.out.println("happy");
                    continue loop;
                }
                for(int i = 0; i < N+1; i++) {
                    if(!visited[i] && cal(node, pos[i])) {
                        que.add(pos[i]);
                        visited[i] = true;
                    }
                }
            }
            System.out.println("sad");
        }
    }
    static boolean cal(int[] node, int[] pos) {
        return Math.abs(node[0] - pos[0]) + Math.abs(node[1] - pos[1]) <= 1000;
    }
}
