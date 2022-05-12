package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10942
public class 팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        boolean[][] check = new boolean[N+1][N+1];
        // 한자리 수 팰린드롬
        for(int i = 1; i <= N; i++) {
            check[i][i] = true;
            if(arr[i-1] == arr[i])
                check[i-1][i] = true;
        }
        // i를 점점 증가시키면서 i 만큼의 크기를 이전의 값이 팰린드롬인지 체크하면서 확인
        for(int i = 2; i <= N; i++) {
            for(int j = 1; i+j <= N; j++) {
                System.out.println(j+"\t"+(i+j)+"\t\t"+(j+1)+"\t"+(i+j-1));
                if(arr[j] == arr[i+j] && check[j+1][i+j-1])
                    check[j][i+j] = true;
            }
        }
        StringBuilder answer = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken()) ;
            answer.append(check[start][end] ? 1 : 0).append("\n");
        }
        System.out.println(answer.toString());
    }
}
