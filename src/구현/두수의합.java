package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/3273
public class 두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        int cnt = 0;
        int start = 0;
        int end = N-1;
        int sum = 0;
        Arrays.sort(arr);
        while(start < end) {
            sum = arr[start]+arr[end];
            if(sum == X)
                cnt++;
            if(sum <= X)
                start++;
            else
                end--;
        }
        System.out.println(cnt);
    }
}
