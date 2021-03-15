package review;

import java.util.*;
import java.io.*;

// 동전
public class acmicpc9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] d = new int[M+1];
            d[0] = 1;
            for(int i = 0; i < N; i++) {
                for(int j = arr[i]; j <= M; j++) {
                    d[j] += d[j-arr[i]];
                }
                System.out.println(Arrays.toString(d));
            }
            System.out.println(d[M]);
        }
    }
}
