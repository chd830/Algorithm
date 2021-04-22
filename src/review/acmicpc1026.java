package review;

import java.util.*;
import java.io.*;

// 보물
public class acmicpc1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a1 = new int[N];
        int[] a2 = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            a1[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            a2[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(a1);
        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(a2[i] < a2[j]) {
                    int tmp = a2[i];
                    a2[i] = a2[j];
                    a2[j] = tmp;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += a1[i] * a2[i];
        }
        System.out.println(sum);
    }
}
