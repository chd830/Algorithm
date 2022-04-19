package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2467
public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 두 개의 용액을 섞어서 특성값이 0에 가장 가까운 용액만들기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        int num1 = 0;
        int num2 = 0;
        int start = 0;
        int end = N-1;
        int sum = Integer.MAX_VALUE;
        while(start < end) {
            int liquid = arr[start]+arr[end];
            if(Math.abs(liquid) <= Math.abs(sum)) {
                sum = arr[start]+arr[end];
                num1 = arr[start];
                num2 = arr[end];
            }
            if(liquid < 0)
                start++;
            else
                end--;
        }
        System.out.println(num1+" "+num2);
    }
}
