package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11054
public class 가장긴바이토닉부분수열 {
    static int N;
    static int[] arr;
    static int[] d1;
    static int[] d2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        d1 = new int[N];
        d2 = new int[N];
        Arrays.fill(d1, 1);
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && d1[i] < d1[j]+1) {
                    d1[i] = d1[j]+1;
                }
            }
        }
        System.out.println(Arrays.toString(d1));
        for(int i = N-1; i >= 0; i--) {
            for(int j = N-1; j > i; j--) {
                if(arr[i] > arr[j] && d2[i] < d2[j]+1) {
                    d2[i] = d2[j]+1;
                }
            }
        }
        System.out.println(Arrays.toString(d2));
        int max = 0;
        for(int i = 0; i < N; i++)
            max = Math.max(max, d1[i]+d2[i]);
        System.out.println(max);
    }
}