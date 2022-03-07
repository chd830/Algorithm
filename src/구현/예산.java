package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2512
public class 예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        모든 요청이 배정될 수 있으면 그대로 배정
        모든 요청이 배정될 수 없으면 정수 상한액을 계산하여 상한액 이상인 예산요청에는 상한액을 배정하고 상한액 이하는 그대로 배정
         */
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        long total = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
            total += arr[i];
        }
        Arrays.sort(arr);
        long sum = Integer.parseInt(br.readLine());
        // 모든 요청이 배정되는 경우
        if(total < sum) {
            System.out.println(arr[N-1]);
        }
        // 모든 요청이 배정될 수 없는 경우
        else {
            long max = sum/N;
            for (int i = 0; i < N - 1; i++) {
                sum -= arr[i];
                max = Math.max(sum / (N - (i + 1)), max);
            }
            System.out.println(max);
        }
    }
}
