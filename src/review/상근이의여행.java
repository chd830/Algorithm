package review;

import java.io.*;
import java.util.StringTokenizer;

// 가중치가 모두 동일하면 모든 노드를 방문하는 최소 값은 N-1
public class 상근이의여행 {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new int[T];
        for(int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            for(int i = 0; i < M; i++) {
                token = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(token.nextToken());
                int num2 = Integer.parseInt(token.nextToken());
            }
            arr[t] = N-1;
        }
        for(int a : arr) {
            System.out.println(a);
        }
    }
}
