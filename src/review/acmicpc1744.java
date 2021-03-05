package review;

import java.util.*;
import java.io.*;

// 수 묶기
public class acmicpc1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        // 음수일 때 계산과 양수일 때 계산을 나눠서 한다.
        long sum = 0;
        int left = 0;
        int right = N-1;
        // 음수
        for(; left < right; left += 2) {
            if(arr[left] < 1 && arr[left+1] < 1) {
                sum += arr[left] * arr[left+1];
            }
            else {
                break;
            }
        }
        // 양수
        for(; 0 < right; right -= 2) {
            if(arr[right] > 1 && arr[right-1] > 1) {
                sum += arr[right] * arr[right-1];
            }
            else {
                break;
            }
        }
        // left와 right사이에 있는 값
        while(left <= right) {
            sum += arr[right--];
        }
        System.out.println(sum);
    }
}
