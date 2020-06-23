package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 센서2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int K = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        int[] distance = new int[N];
        for(int i = 1; i < N; i++) {
            distance[i-1] = arr[i] - arr[i-1];
        }
        Arrays.sort(distance);
        int res = 0;
        for(int i = 0; i < N-K+1; i++) {
            res += distance[i];
        }
        System.out.println(res);
    }
}
