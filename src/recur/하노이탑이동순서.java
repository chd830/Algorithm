package recur;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11729
public class 하노이탑이동순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        hanoi(1, 2, 3, N);
    }
    static void hanoi(int start, int from, int to, int N) {
        if(N == 1) {
            System.out.println(start + " " + to);
            return;
        }
        // 첫번재 막대에서 두번째 막대로 이동
        hanoi(start, to, from, N-1);
        System.out.println(start+" "+to);
        // 두번째 막대에서 세번째 막대로 이동
        hanoi(from, to, start, N-1);
    }
}
