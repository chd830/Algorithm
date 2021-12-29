package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1697
public class 숨바꼭질1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] arr = new int[100001];
        Arrays.fill(arr, -1);
        if(N >= M) {
            System.out.println(N-M);
            System.exit(0);
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        arr[N] = 0;
        while(!que.isEmpty()) {
            int n = que.poll();
            if(n == M)
                break;
            if(n*2 < arr.length && arr[n*2] == -1) {
                que.add(n * 2);
                arr[n * 2] = arr[n] + 1;
            }
            if(n+1 < arr.length && arr[n+1] == -1) {
                que.add(n + 1);
                arr[n + 1] = arr[n] + 1;
            }
            if(n-1 >= 0 && arr[n-1] == -1) {
                que.add(n - 1);
                arr[n - 1] = arr[n] + 1;
            }
        }
        System.out.println(arr[M]);
    }
}
