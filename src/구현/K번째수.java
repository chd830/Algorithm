package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1300
public class K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
//        for(int i = 1; i <= N; i++) {
//            for(int j = 1; j <= N; j++)
//                System.out.print(i*j+"\t");
//            System.out.println();
//        }
        int start = 1;
        int end = K;
        int result = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            if(count(mid, N) >= K) {
                result = mid;
                end = mid-1;
            }
            else
                start = mid+1;
        }
        System.out.println(result);
    }
    static int count(int num, int N) {
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            cnt += Math.min(num/i, N);
        }
        return cnt;
    }
}
