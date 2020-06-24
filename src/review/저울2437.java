package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 저울2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(solve(arr, N));
    }
    public static int solve(int[] arr, int n) {
        //첫값이 1이 아니게 된다면 sum과 1이상차이가 나게 되므로 바로 1반환
        if(arr[0] != 1) {
            return 1;
        }
        int sum = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] > sum+1) {
                return sum+1;
            }
            sum += arr[i];
        }
        //마지막에 주어진값보다 더 클때도 sum+1로 반환하는거 잊지않기
        return sum+1;
    }
}
