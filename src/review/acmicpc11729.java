package review;

import java.util.*;
import java.io.*;

// 하노이 탑 이동 순서
public class acmicpc11729 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, N)-1).append("\n");
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }
    static void hanoi(int N, int start, int mid, int end) {
        if(N == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        hanoi(N-1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(N-1, mid, start, end);
    }
}
