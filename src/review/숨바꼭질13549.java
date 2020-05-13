package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질13549 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] cnt = new int[100001];
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        cnt[N] = 1;
        while(!que.isEmpty()) {
            int n = que.poll();
            if(n == K) {
                System.out.println(cnt[K]-1);
                System.exit(0);
            }
            if(n*2 < cnt.length && cnt[n*2] == 0) {
                cnt[n*2] = cnt[n];
                que.add(n*2);
            }
            if(n-1 >= 0 && cnt[n-1] == 0) {
                que.add(n-1);
                cnt[n-1] = cnt[n]+1;
            }
            if(n+1 < cnt.length && cnt[n+1] == 0) {
                cnt[n+1] = cnt[n]+1;
                que.add(n+1);
            }
        }
    }
}