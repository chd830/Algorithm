package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14719
public class 빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(token.nextToken());
        int W = Integer.parseInt(token.nextToken());
        int[] arr = new int[W];
        int answer = 0;
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        for(int i = 1; i < W-1; i++) {
            int left = 0;
            int right = 0;
            // i보다 작은 값 중에서 최댓값이 왼쪽의 기둥이 됨.
            for(int j = 0; j < i; j++)
                left = Math.max(left, arr[j]);
            // i보다 큰 값 중에서 최댓값이 오른쪽의 기둥이 됨.
            for(int j = W-1; j > i; j--)
                right = Math.max(right, arr[j]);
            // left와 right는 i가 들어있을 수 있는 제일 큰 공간을 지지하는 기둥
            answer += Math.max(0, Math.min(left, right)-arr[i]);
        }
        System.out.println(answer);
    }
}
