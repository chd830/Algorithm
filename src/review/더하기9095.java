package review;

import java.io.*;

public class 더하기9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[15];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i = 4; i < 12; i++) {
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
        }
        for(int t = 0; t < T; t++ ){
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[N]);
        }
    }
}
