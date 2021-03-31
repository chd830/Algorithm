package review;

import java.util.*;
import java.io.*;

// 빗물
public class acmicpc14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int res = 0;
        int[] arr = new int[m];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        for(int i = 1; i < m-1; i++) {
            int left = 0;
            int right = 0;
            for(int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }
            for(int j = i+1; j < m; j++) {
                right = Math.max(right, arr[j]);
            }
            res += Math.max(0, Math.min(left, right)-arr[i]);
        }
        System.out.println(res);
    }
}
