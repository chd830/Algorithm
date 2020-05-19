package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int l = 0;
        int r = 0;
        int diff = 0;
        int result = Integer.MAX_VALUE;
        while(l <= r && r < N) {
            if(diff >= M) {
                result = Math.min(result, diff);
                if(l == r) {
                    r++;
                    if(r == N) {
                        break;
                    }
                    diff = arr[r] - arr[l];
                }
                else {
                    l++;
                    diff = arr[r] - arr[l];
                }
            }
            else {
                r++;
                if(r == N) {
                    break;
                }
                diff = arr[r] - arr[l];
            }
        }
        System.out.println(result);
    }
}
