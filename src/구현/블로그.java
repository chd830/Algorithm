package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/21921
public class 블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        int sum = 0;
        int max = 0;
        int cnt = 1;
        for(int i = 0; i < X; i++) {
            sum += arr[i];
        }
        max = sum;
        for(int i = 0; i < N-X; i++) {
            sum = sum - arr[i] + arr[i+X];
            if(sum > max) {
                max = sum;
                cnt = 1;
            }
            else if(sum == max)
                cnt++;
            else
                continue;
        }
        StringBuilder sb = new StringBuilder();
        if(max == 0)
            sb.append("SAD");
        else
            sb.append(max).append("\n").append(cnt);
        System.out.println(sb.toString());
    }
}
