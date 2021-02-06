package review;

import java.util.*;
import java.io.*;

public class 카잉달력 {
    static int N;
    static int M;
    static int x;
    static int y;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            res = 0;
            token = new StringTokenizer(br.readLine());
            M = Integer.parseInt(token.nextToken());
            N = Integer.parseInt(token.nextToken());
            x = Integer.parseInt(token.nextToken());
            y = Integer.parseInt(token.nextToken());

            int cnt = x%(M+1);
            int tmp = x;
            for(int i = 0; i < N; i++) {
                int ty = tmp % N == 0 ? N : tmp%N;
                if(ty == y) {
                    break;
                }
                tmp = ty + M;
                cnt += M;
            }
            sb.append(cnt > lcm(M, N) ? -1 : cnt).append("\n");
        }
        System.out.println(sb);
    }
    static int lcm(int x, int y) {
        int tmpX = x;
        int tmpY = y;
        while(y != 0) {
            int r = x%y;
            x = y;
            y = r;
        }
        return tmpX*tmpY / x;
    }
}