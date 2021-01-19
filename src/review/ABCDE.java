package review;

import java.util.*;
import java.io.*;

public class ABCDE {
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean check;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        list = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        check = false;
        for(int i = 0; i < N; i++) {
            recur(i, 1);
        }
        System.out.println(0);
    }
    static void recur(int idx, int cnt) {
        if(cnt == 5) {
            System.out.println(1);
            System.exit(0);
            return;
        }
        visited[idx] = true;
        for(int i : list[idx]) {
            if(!visited[i]) {
                recur(i, cnt+1);
            }
        }
        visited[idx] = false;
    }
}
