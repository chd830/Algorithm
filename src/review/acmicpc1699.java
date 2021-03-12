package review;

import java.util.*;
import java.io.*;

// 제곱수의 합
public class acmicpc1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[100001];
        Arrays.fill(d, 100001);
        d[0] = 0;
        d[1] = 1;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j*j <= i; j++) {
                d[i] = Math.min(d[i - j * j] + 1, d[i]);
            }
        }
        System.out.println(d[N]);
    }
}
