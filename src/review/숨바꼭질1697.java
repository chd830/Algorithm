package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숨바꼭질1697 {
    static int[] arr;
    static int K;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        arr = new int[100001];
        arr[N] = 1;
        dfs(N);
    }
    static void dfs(int cur) {
        if(cur == K) {
            for(int i = 0; i <= K+N; i++) {
                System.out.print(i+"\t");
            }
            System.out.println();
            for(int i = 0; i <= K+N; i++) {
                System.out.print(arr[i]+"\t");
            }
            System.out.println();
            System.out.println(arr[K]-1);
            System.exit(0);
        }
        if(cur*2 <= K+N) {
            arr[cur*2] = arr[cur]+1;
            dfs(cur*2);
        }
        if(cur-1 >= 0) {
            arr[cur-1] = arr[cur]+1;
            dfs(cur-1);
        }
        if(cur+1 <= K) {
            arr[cur+1] = arr[cur]+1;
            dfs(cur+1);
        }
    }
}
