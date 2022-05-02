package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1010
public class 다리놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            // mCn구하기
            if(n == 0 || m == n)
                System.out.println(1);
            else {
                System.out.println(comb(m, n));
            }
        }
    }
    static int[][] d = new int[30][30];
    static int comb(int m, int n) {
        if(d[m][n] > 0)
            return d[m][n];
        if(n == 0 || m == n)
            return 1;
        return d[m][n] = comb(m-1, n)+comb(m-1, n-1);
    }
}