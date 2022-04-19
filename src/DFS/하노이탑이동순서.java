package DFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11729
public class 하노이탑이동순서 {
    static StringBuilder sb;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        hanoi(1, 2, 3, N);
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
    static void hanoi(int from, int mid, int to, int N) {
        cnt++;
        if(N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(from, to, mid, N-1);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(mid, from, to, N-1);
    }
}
