package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 바이러스 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//        List<Integer>[] computers = new ArrayList[N+1];
//        for(int i = 0; i <= N; i++) {
//            computers[i] = new ArrayList<>();
//        }
//        StringTokenizer token = null;
//        for(int i = 0; i < M; i++) {
//            token = new StringTokenizer(br.readLine());
//            int num1 = Integer.parseInt(token.nextToken());
//            int num2 = Integer.parseInt(token.nextToken());
//            computers[num1].add(num2);
//            computers[num2].add(num1);
//        }
//
//        boolean[] visited = new boolean[N+1];
//        Queue<Integer> que = new LinkedList<>();
//        que.add(1);
//        visited[1] = true;
//        while(!que.isEmpty()) {
//            int num = que.poll();
//            visited[num] = true;
//            for(int i = 0; i < computers[num].size();i++) {
//                if(!visited[computers[num].get(i)]) {
//                    que.add(computers[num].get(i));
//                    visited[computers[num].get(i)] = true;
//                }
//            }
//            for(int compute : computers[num]) {
//                if(!visited[compute]) {
//                    que.add(compute);
//                    visited[compute] = true;
//                }
//            }
//        }
//        int cnt = 0;
//        for(int i = 0; i <= N; i++) {
//            if(visited[i]) {
//                cnt++;
//            }
//        }
//        System.out.println(cnt-1);
//    }
    static List<Integer>[] list;
    static boolean[][] arrs;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        N = Integer.parseInt(br.readLine()) + 1;
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N];
//        인접리스트
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(token.nextToken());
            int num2 = Integer.parseInt(token.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visited[1] = true;
        while (!que.isEmpty()) {
            int n = que.poll();
            for (int num : list[n]) {
                if (!visited[num]) {
                    visited[num] = true;
                    que.add(num);
                    cnt++;
                }
            }
            System.out.println(cnt);
//        인접배열
            arrs = new boolean[N][N];

            for (int i = 0; i < M; i++) {
                token = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(token.nextToken());
                int num2 = Integer.parseInt(token.nextToken());
                arrs[num1][num2] = true;
                arrs[num2][num1] = true;
            }

            cnt = 0;
            que = new LinkedList<>();
            que.add(1);
            visited[1] = true;
            while (!que.isEmpty()) {
                n = que.poll();
                for (int i = 0; i < N; i++) {
                    if (arrs[n][i] && !visited[i]) {
                        que.add(i);
                        visited[i] = true;
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
