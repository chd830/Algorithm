package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/12851
public class 숨바꼭질2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        if(N >= K) {
            System.out.println((N - K)+"\n1");
            return;
        }
        arr = new int[Math.max(N, K)*2];
        bfs();
        System.out.println(min+"\n"+count);
    }
    static int N;
    static int K;
    static int min;
    static int count;
    static int[] arr;
    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        min = Integer.MAX_VALUE;
        arr[N] = 1;
        count = 0;
        while(!que.isEmpty()) {
            int n = que.poll();
            if(min < arr[n])
                return;
            for(int i = 0; i < 3; i++) {
                int next;
                if(i == 0)
                    next = n+1;
                else if(i == 1)
                    next = n-1;
                else
                    next = n*2;
                if(next < 0 || next > arr.length)
                    continue;
                if(next == K) {
                    min = arr[n];
                    count++;
                }
                if(arr[next] == 0 || arr[next] == arr[n]+1) {
                    que.add(next);
                    arr[next] = arr[n]+1;
                }
            }
        }
    }
}
