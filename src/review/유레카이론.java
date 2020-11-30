package review;

import java.io.*;
import java.util.Arrays;

public class 유레카이론 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= 1000; i++) {
            setArrays(i);
        }
        for(int t = 0; t < T; t++) {
            check = false;
            K = Integer.parseInt(br.readLine());
            perm(0);
            System.out.println(check ? 1 : 0);
        }
    }
    static int K;
    static boolean check;
    public static void perm(int idx) {
        if(idx == 3) {
            int sum = arrays[sub[0]] + arrays[sub[1]] + arrays[sub[2]];
            if(K == sum) {
                check = true;
            }
            return;
        }
        int limit = 0;
        for(int i = 1; i <= K; i++) {
            if(arrays[i] < K) {
                limit = i;
            }
        }
        for(int i = 1; i <= limit; i++) {
            sub[idx] = i;
            perm(idx+1);
        }
    }
    static int[] sub = new int[3];
    static int[] arrays = new int[1001];
    public static void setArrays(int idx) {
        for(int i = 1; i <= idx; i++) {
            arrays[idx] += i;
        }
    }
}
