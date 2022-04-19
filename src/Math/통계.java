package Math;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2108
public class 통계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] cnt = new int[8001];
        int sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            cnt[4000+arr[i]]++;
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        // 산술평균
        sb.append(Math.round((double)sum/N)).append("\n");
        // 중앙값
        sb.append(arr[N/2]).append("\n");
        // 최빈값(여러개 일때는 두번째로 작은 값)
        int max = 0;
        for(int i = 4000+arr[0]; i <= 4000+arr[N-1]; i++) {
            max = Math.max(cnt[i], max);
        }
        int count = 0;
        int maxRes = 0;
        for(int i = 4000+arr[0]; i <= 4000+arr[N-1]; i++) {
            if(cnt[i] == max) {
                count++;
                if(count == 2) {
                    sb.append(i-4000).append("\n");
                    break;
                }
                maxRes = i;
            }
        }
        if(count < 2)
            sb.append(maxRes-4000).append("\n");
        // 범위
        sb.append(arr[N-1]-arr[0]);
        System.out.println(sb.toString());
    }
}
