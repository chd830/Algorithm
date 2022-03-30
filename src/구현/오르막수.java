package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11057
public class 오르막수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())+1;
        int[][] d = new int[1002][10];
        Arrays.fill(d[1], 1);
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k <= j; k++) {
                    d[i][j] += d[i-1][k]%10007;
                }
            }
        }
        System.out.println(d[N][9]%10007);
    }
}