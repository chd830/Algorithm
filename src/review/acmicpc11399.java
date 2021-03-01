package review;

import java.util.*;
import java.io.*;

// ATM
public class acmicpc11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        long prev = arr[0];
        for(int i = 1; i < N; i++) {
            arr[i] += arr[i-1];
            prev += arr[i];
        }
        System.out.println(prev);
    }
}