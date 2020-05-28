package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑 {
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }
    static void hanoi(int N, int from, int by, int to) {
        cnt++;
        if(N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
        }
        else {
            //마지막 탑을 보조탑으로 사용하여 첫번째탑의 N-1개의 원반을 중간으로 이동
            hanoi(N-1, from, to, by);
            sb.append(from).append(" ").append(to).append("\n");
            //첫번째 탑을 보조탑으로 사용하여 중간탑의 N-1개의 원반을 마지막탑으로 이동
            hanoi(N-1, by, from, to);
        }
    }
}

