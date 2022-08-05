package Graph;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/86971
public class P_전력망을둘로나누기 {
    public static void main(String[] args) {
        System.out.println(solution(9, new int[][] {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }
    static List<Integer>[] list;
    public static int solution(int n, int[][] wires) {
        list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        for(int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        min = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++) {
            count(wires[i][0], wires[i][1], n);
        }
        return min;
    }
    static int min;
    static int result;
    static void count(int start, int end, int size) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[size+1];
        visited[start] = true;
        visited[end] = true;
        int cnt = 1;
        for(int i : list[start]) {
            if(i != end) {
                que.add(i);
                cnt++;
                visited[i] = true;
            }
        }
        while(!que.isEmpty()) {
            int n = que.poll();
            for(int i : list[n]) {
                if(!visited[i]) {
                    visited[i] = true;
                    cnt++;
                    que.add(i);
                }
            }
        }
        if(min > Math.abs(size-cnt-cnt)) {
            min = Math.abs(size-cnt-cnt);
            result = cnt;
        }
    }
}
