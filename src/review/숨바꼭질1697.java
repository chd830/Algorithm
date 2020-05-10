package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] arr = new int[100001];
        if(N >= K) {
            System.out.println(N-K);
            System.exit(0);
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        while(!que.isEmpty()) {
            N = que.poll();
            if(N == K) {
                break;
            }
            if(N+1 <= 100000 && arr[N+1] == 0) {
                arr[N+1] = arr[N] + 1;
                que.add(N+1);
            }
            if(N-1 >= 0 && arr[N-1] == 0) {
                arr[N-1] = arr[N] +1;
                que.add(N-1);
            }
            if(N*2 <= 100000 && arr[N*2] == 0) {
                arr[N*2] = arr[N] + 1;
                que.add(N*2);
            }
        }
        System.out.println(arr[K]);
    }
}
