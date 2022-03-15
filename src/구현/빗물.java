package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14719
public class 빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(token.nextToken());
        int W = Integer.parseInt(token.nextToken());
        int[] arr = new int[W+1];
        int answer = 0;
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        for(int i = 1; i < W-1; i++) {
            int left = 0;
            int right = 0;
            for(int j = 0; j < i; j++)
                left = Math.max(left, arr[j]);
            for(int j = W-1; j > i; j--)
                right = Math.max(right, arr[j]);
            // i를 기준으로 왼쪽 벽과 오른쪽 벽을 찾고 물이 채워지는 값을 구함
            answer += Math.max(0, Math.min(left, right)-arr[i]);
        }
        System.out.println(answer);
    }
}
