package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수묶기1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        long ans = 0;
        //왼쪽부터 시작해서 0보다 작은 값일때만 곱해서 ans에 더한다.
        for(; left < right; left += 2) {
            if(arr[left] < 1 && arr[left+1] < 1) {
                ans += arr[left] * arr[left+1];
            }
            else {
                break;
            }
        }
        //오른쪽부터 시작해서 0 보다 큰 값일때만 곱해서 ans에 더한다.
        for(; right > 0; right -= 2) {
            if(arr[right] > 1 && arr[right-1] > 1) {
                ans += arr[right] * arr[right-1];
            }
            else {
                break;
            }
        }
        //오른쪽에서 온 값과 왼쪽에서 온 값중에서 방문하지 않은 위치를 더한다.
        for(; right >= left; right--) {
            ans += arr[right];
        }
        System.out.println(ans);
    }
}