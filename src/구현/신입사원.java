package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1946
public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] n = new int[N+1];
            for(int i = 0; i < N; i++) {
                token = new StringTokenizer(br.readLine());
                n[Integer.parseInt(token.nextToken())] = Integer.parseInt(token.nextToken());
            }
            int tmp = n[1];
            int answer = 1;
            for(int i = 2; i <= N; i++) {
                if(tmp > n[i]) {
                    tmp = n[i];
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}
