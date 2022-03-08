package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/6588
public class 골드바흐의추측 {
    static void prime() {
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for(int i = 2; i < arr.length; i++) {
            for(int j = i+i; j < arr.length; j += i) {
                arr[j] = false;
            }
        }
    }
    static boolean[] arr = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        prime();
        int N = Integer.parseInt(br.readLine());
        loop: while(N != 0) {
            int left = 0;
            int right = N;
            for(int i = 0; i <= N/2; i++) {
                if(arr[left] && arr[right])
                    break;
                left++;
                right--;
            }
            if(left == 0 && right == N)
                sb.append("Goldbach's conjecture is wrong.");
            else
                sb.append(N).append(" = ").append(left).append(" + ").append(right).append("\n");
            N = Integer.parseInt(br.readLine());
        }
        System.out.println(sb.toString());
    }
}
