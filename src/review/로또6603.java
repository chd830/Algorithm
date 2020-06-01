package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(token.nextToken());
            if(K == 0) {
                System.exit(0);
            }
            lotto = new int[6];
            arr = new int[K];
            visited = new boolean[K];
            for(int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
            pick(0, 0);
            System.out.println();
        }
    }
    static int[] arr;
    static int[] lotto;
    static boolean[] visited;
    static void pick(int cnt, int idx) {
        if(cnt == lotto.length) {
            for(int l : lotto) {
                System.out.print(l+" ");
            }
            System.out.println();
            return;
        }
        if(idx == arr.length) {
            return;
        }
        if(!visited[idx]) {
            visited[idx] = true;
            lotto[cnt] = arr[idx];
            pick(cnt+1, idx+1);
            visited[idx] = false;
        }
        pick(cnt, idx+1);
    }
}
