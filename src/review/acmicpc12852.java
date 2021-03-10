package review;

import java.util.*;
import java.io.*;

// 1로 만들기
public class acmicpc12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];
        int[] prev = new int[N+1];
        for(int i = 2; i <= N; i++) {
            d[i] = d[i-1]+1;
            prev[i] = i-1;
            if(i%2 == 0 && d[i] > d[i/2]+1) {
                prev[i] = i/2;
                d[i] = d[i/2]+1;
            }
            if(i%3 == 0 && d[i] > d[i/3]+1) {
                prev[i] = i/3;
                d[i] = d[i/3]+1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d[N]).append("\n").append(N).append(" ");
        while(prev[N] != 0) {
            sb.append(prev[N]).append(" ");
            N = prev[N];
        }
        System.out.println(sb);
    }
}