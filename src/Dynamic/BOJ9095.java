package Dynamic;

import java.io.*;

// https://www.acmicpc.net/problem/9095
public class BOJ9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] d = new int[12];
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            d[0] = 0;
            // 1
            d[1] = 1;
            // 1+1 2
            d[2] = 2;
            // 1+1+1 2+1 1+2 3
            d[3] = 4;
//            // 1+1+1+1 1+1+2 2+1+1 1+2+1 3+1 2+2 1+3
//            d[4] = 6;
            for(int i = 4; i <= N; i++)
                d[i] = d[i-1]+d[i-2]+d[i-3];
            sb.append(d[N]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
