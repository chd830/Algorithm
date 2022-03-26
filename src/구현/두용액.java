package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2470
public class 두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        int x = arr[0];
        int y = arr[N-1];
        if(arr[0] >= 0) {
            x = arr[0];
            y = arr[1];
        }
        else if(arr[N-1] < 0) {
            x = arr[N-2];
            y = arr[N-1];
        }
        else {
            int start = 0;
            int end = N - 1;
            int sum = x+y;
            int min = sum;
            while (start < end) {
                sum = arr[start]+arr[end];
                if (Math.abs(min) > Math.abs(sum)) {
                    x = arr[start];
                    y = arr[end];
                    min = arr[start] + arr[end];
                }
                if (sum < 0)
                    start++;
                else if (sum > 0)
                    end--;
                else
                    break;
            }
        }
        System.out.println(x+" "+y);
    }
}
/*
6
-99 -60 3 7 61 130

7
-99 -2 -1 1 98 100 101
 */
