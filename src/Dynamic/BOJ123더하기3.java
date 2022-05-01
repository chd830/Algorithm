package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15988
public class BOJ123더하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] d = new long[1000001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i = 4; i < d.length; i++)
            d[i] = (d[i-3]+d[i-2]+d[i-1])%1000000009;
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(d[N]);
        }
    }
}
