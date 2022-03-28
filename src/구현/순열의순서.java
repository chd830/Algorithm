package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1722
public class 순열의순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 1부터 N까지 N개의 수를 사용한 수열
        StringTokenizer token = new StringTokenizer(br.readLine());
        boolean[] visit = new boolean[21];
        long[] factorial = new long[21];
        Arrays.fill(factorial, 1);
        for(int i = 1; i <= 20; i++)
            factorial[i] = factorial[i-1]*i;
        int[] arr = new int[N];
        long ans = 1;
//        for(int i = N-1; i >= 0; i--)
//            System.out.print(factorial[i]+"\t");
//        System.out.println();
        StringBuilder sb = new StringBuilder();
        switch (Integer.parseInt(token.nextToken())) {
            //k번째 순열 구하기
            case 1:
                long k = Long.parseLong(token.nextToken());
                for(int i = 0; i < N; i++) {
                    for(int j = 1; j <= N; j++) {
                        if (visit[j]) continue;
                        // 팩토리얼 값만큼 빼주면서 계산
                        if(factorial[N-i-1] < k)
                            k -= factorial[N-i-1];
                        else {
                            arr[i] = j;
                            visit[j] = true;
                            break;
                        }
                    }
                }
                for(int i = 0; i < N; i++)
                    sb.append(arr[i]).append(" ");
                break;
            // 주어진 순열이 몇번째인지 구하기
            case 2:
                for(int i = 0; i < N; i++) {
                    arr[i] = Integer.parseInt(token.nextToken());
                }
                for(int i = 0; i < N; i++) {
                    // 팩토리얼 값을 더해주며 계산
                    for(int j = 1; j < arr[i]; j++) {
                        if(visit[j])
                            continue;
                        ans += factorial[N-i-1];
                    }
                    visit[arr[i]] = true;
                }
                sb.append(ans);
                break;
        }
        System.out.println(sb.toString());
    }
}
