package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2473
public class 세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        Arrays.sort(arr);
        int[] answer = new int[3];
        answer[0] = arr[0];
        answer[1] = arr[1];
        answer[2] = arr[N-1];
        long min = Long.MAX_VALUE;
        for(int i = 0; i < N-2; i++) {
            int first = i;
            int start = i+1;
            int end = N-1;
            min = Math.min(min, (long)arr[first]+arr[start]+arr[end]);
            while(start < end) {
                long sum = (long)arr[first]+arr[start]+arr[end];
                if(Math.abs(sum) < Math.abs(min)) {
                    min = sum;
                    answer[0] = arr[first];
                    answer[1] = arr[start];
                    answer[2] = arr[end];
                }
                if(sum > 0)
                    end--;
                else
                    start++;
            }
        }
        Arrays.sort(answer);
        for(int j = 0; j < 3; j++)
            System.out.print(answer[j]+" ");
    }
}
