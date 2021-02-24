package review;

import java.util.*;
import java.io.*;

public class acmicpc2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long d[] = new long[N+1];
        d[0] = 0;
        d[1] = 1;
        for(int i = 2; i <= N; i++) {
            d[i] = d[i-2] + d[i-1];
        }
        System.out.println(d[N]);
    }
}
