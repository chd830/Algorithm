package BFS.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑이동순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cnt = 0;
        sb = new StringBuilder();
        hanoi(N, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }
    static int cnt;
    static StringBuilder sb;
    static void hanoi(int N, int from, int by, int to) {
        cnt++;
        if(N==1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(N-1, from, to, by);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(N-1, by, from, to);
    }
}
