package net.acmicpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 텀프로젝트 {
    static int N;
    static int cnt;
    static int[] arr;
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            arr = new int[N+1];
            list = new ArrayList[N+1];
            for(int i = 0; i < N+1; i++) {
                list[i] = new ArrayList();
            }
            int result = 0;
            for(int i = 1; i <= N; i++) {
                int num = sc.nextInt();
                list[i].add(num);
            }
            visited = new boolean[N+1];
            for(int i = 1; i <= N; i++) {
                cnt = 0;
            }
            System.out.println(result);
        }
    }
    static int dfs(int start, int num) {
        if(visited[num]) {
            return num;
        }
        if(start == num) {
            return start;
        }
        visited[num] = true;
        return dfs(start, arr[num]);
    }
}
